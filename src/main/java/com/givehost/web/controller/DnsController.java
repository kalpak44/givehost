package com.givehost.web.controller;

import com.givehost.web.serviice.SecurityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DnsController {
    private SecurityService securityService;

    public DnsController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @GetMapping("/dns")
    public String showHomePage(Model model) {
        if (securityService.isAuthenticated()) {
            return "/pages/user-dns-page";
        } else {
            return "/pages/home";
        }
    }
}
