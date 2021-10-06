package com.givehost.web.controller;

import com.givehost.web.model.User;
import com.givehost.web.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {
    private UserRepository userRepository;

    public SignInController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/sign-in")
    public String showUserList(Model model) {
        System.out.println("sign in");
        Iterable<User> all = userRepository.findAll();
        model.addAttribute("user", all);
        for (User user: all){
            System.out.println(user.getEmail());
        }
        return "/pages/sign-in";
    }
}
