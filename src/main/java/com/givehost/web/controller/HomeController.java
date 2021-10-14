package com.givehost.web.controller;

import com.givehost.web.serviice.SecurityService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private SecurityService securityService;

    public HomeController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @GetMapping("/")
    public String showHomePage(Model model) {
        if (securityService.isAuthenticated()) {
            //tmp
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User principal = (User) authentication.getPrincipal();
            String email = principal.getUsername();
            model.addAttribute("names", email);
            return "/pages/user-home-page";
        } else {
            return "/pages/home";
        }
    }
}
