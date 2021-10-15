package com.givehost.web.controller;

import com.givehost.web.serviice.SecurityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HostingController {
    private SecurityService securityService;

    public HostingController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @GetMapping("/hosting")
    public String showHomePage(Model model) {
        if (securityService.isAuthenticated()) {
            return "/pages/user-hosting-page";
        } else {
            return "/pages/home";
        }
    }
}
