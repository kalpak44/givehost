package com.givehost.web.controller;

import com.givehost.web.serviice.SecurityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInpController {
    private SecurityService securityService;


    public SignInpController(SecurityService securityService) {

        this.securityService = securityService;
    }

    @GetMapping("/sign-in")
    public String showUserList() {
        if (securityService.isAuthenticated()) {
            return "redirect:/";
        }
        return "/pages/sign-in-page";
    }
}
