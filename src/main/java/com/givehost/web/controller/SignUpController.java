package com.givehost.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignUpController {
    @GetMapping("/sign-up")
    public String showUserList(Model model) {
        return "/pages/register-page";
    }
}
