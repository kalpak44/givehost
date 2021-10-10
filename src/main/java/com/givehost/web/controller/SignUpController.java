package com.givehost.web.controller;

import com.givehost.web.model.User;
import com.givehost.web.serviice.SecurityService;
import com.givehost.web.serviice.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {
    private UserService userService;
    private SecurityService securityService;


    public SignUpController(UserService userService, SecurityService securityService) {
        this.userService = userService;
        this.securityService = securityService;
    }

    @GetMapping("/sign-up")
    public String showUserList() {
        if (securityService.isAuthenticated()) {
            return "redirect:/";
        }
        return "/pages/register-page";
    }

    @PostMapping("/sign-up")
    public String signUp(Model model, @ModelAttribute User user) {
        if (!validNames(user.getNames())) {
            model.addAttribute("success", false);
            model.addAttribute("message", "names should contains at least 2 characters");
            return "/pages/register-page";
        }
        if (!validEmail(user.getEmail())) {
            model.addAttribute("success", false);
            model.addAttribute("message", "your email address is not valid format");
            return "/pages/register-page";
        }

        if (userService.findByEmail(user.getEmail()) != null) {
            model.addAttribute("success", false);
            model.addAttribute("message", "User with this email already exits");
            return "/pages/register-page";
        }

        if (!validPassword(user.getPassword())) {
            model.addAttribute("success", false);
            model.addAttribute("message", "password should contains at least 4 characters");
            return "/pages/register-page";
        }

        userService.save(user);
        securityService.autoLogin(user.getEmail(), user.getPassword());
        return "redirect:/";

    }

    private boolean validPassword(String password) {
        return password != null && !password.isEmpty() && password.length() > 2 && password.length() < 255;
    }

    private boolean validEmail(String email) {
        return email != null && !email.isEmpty() && email.matches("(.+)@(.+)");
    }

    private boolean validNames(String names) {
        return names != null && !names.isEmpty() && names.length() >= 2 && names.length() <= 255;
    }
}
