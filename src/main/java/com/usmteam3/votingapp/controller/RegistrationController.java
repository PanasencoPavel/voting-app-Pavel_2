package com.usmteam3.votingapp.controller;

import com.usmteam3.votingapp.model.User;
import com.usmteam3.votingapp.model.enums.Role;
import com.usmteam3.votingapp.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.Optional;

//import static java.util.Collections.*;

@Controller
@RequestMapping("/register")
public class RegistrationController {

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
    public String processRegistration(User user) {
        Optional<User> userFromDb = userService.getUserByEmail(user.getEmail());
        if (userFromDb.isPresent()) {
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userService.addNewUser(user);

        return "redirect:/login";

    }
}