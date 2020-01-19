package com.usmteam3.votingapp.controller;

import com.usmteam3.votingapp.dao.UserRepository;
import com.usmteam3.votingapp.model.User;
import com.usmteam3.votingapp.model.enums.Role;
import com.usmteam3.votingapp.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.Map;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    private UserServiceImpl userService;
//    private PasswordEncoder passwordEncoder;

    public RegistrationController(
            UserServiceImpl userRepo
    ) {
        this.userService = userRepo;
//        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm() {
        return "register";
    }

    @PostMapping
    public String processRegistration(User user, Map<String, Object> model) {
        User userFromDb = userRepository.findByEmail(user.getEmail());

        if (userFromDb != null) {
            model.put("message", "That email already exists! Please write another one");
            return "register";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userService.addNewUser(user);

        return "redirect:/login";
    }
}