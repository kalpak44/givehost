package com.givehost.web.controller;

import com.givehost.web.serviice.SecurityService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VpsController {
    private SecurityService securityService;

    public VpsController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @GetMapping("/vps")
    public String showHomePage(Model model) {
        if (securityService.isAuthenticated()) {
            return "/pages/user-vps-page";
        } else {
            return "/pages/home";
        }
    }
}
