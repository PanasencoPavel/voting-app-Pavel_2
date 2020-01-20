package com.usmteam3.votingapp.controller;

import com.usmteam3.votingapp.dao.UserRepository;
import com.usmteam3.votingapp.model.Rating;
import com.usmteam3.votingapp.model.User;
import com.usmteam3.votingapp.model.enums.Role;
import com.usmteam3.votingapp.service.impl.RatingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RatingServiceImpl ratingService;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String userList(Model model) {

        model.addAttribute("users", userRepository.findAll());

        return "userList";
    }

    @GetMapping("{user}/edit")
    public String userEdit(@PathVariable User user, Model model) {

        Iterable<Rating> ratings = ratingService.getAllRatingsByUserId(user.getId());

        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        model.addAttribute("ratings", ratings);

        return "userEdit";
    }

    @GetMapping("{user}")
    public String userProfile(@PathVariable User user, Model model) {

        Iterable<Rating> ratings = ratingService.getAllRatingsByUserId(user.getId());

        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        model.addAttribute("ratings", ratings);

        return "userProfile";
    }

    @PostMapping("/edit")
    public String userSave(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ) {
        user.setFirstName(firstName);
        user.setLastName(lastName);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepository.save(user);

        return "redirect:/user/{user}";
    }
}

