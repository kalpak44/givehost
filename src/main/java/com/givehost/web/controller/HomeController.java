package com.givehost.web.controller;

import com.givehost.web.serviice.SecurityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private SecurityService securityService;

    public HomeController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @GetMapping("/")
    public String showHomePage() {
        if (securityService.isAuthenticated()) {
            return "/pages/profile-page";
        } else {
            return "/pages/home";
        }
    }
}
