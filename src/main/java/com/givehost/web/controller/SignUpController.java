package com.givehost.web.controller;

import com.givehost.web.model.User;
import com.givehost.web.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignUpController {
    private UserRepository userRepository;

    public SignUpController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/sign-up")
    public String showUserList(Model model) {
        System.out.println("sign up");
        User n = new User();
        n.setName("user");
        n.setEmail("user@mail.com");
        userRepository.save(n);

        return "/pages/sign-up";
    }
}
