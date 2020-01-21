package com.usmteam3.votingapp.controller;

import com.usmteam3.votingapp.dao.UserRepository;
import com.usmteam3.votingapp.model.Rating;
import com.usmteam3.votingapp.model.User;
import com.usmteam3.votingapp.service.impl.RatingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RatingServiceImpl ratingService;

    @GetMapping("/user/edit")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String userList(Model model) {

        model.addAttribute("users", userRepository.findAll());

        return "userList";
    }

    @GetMapping("user/{user}")
    public String userProfile(@PathVariable User user, Model model) {

        Iterable<Rating> ratings = ratingService.getAllRatingsByUserId(user.getId());

        model.addAttribute("user", user);
        model.addAttribute("ratings", ratings);

        return "userProfile";
    }

    @GetMapping("user/{user}/edit")
    public String userEdit(@PathVariable User user, Model model) {

        Iterable<Rating> ratings = ratingService.getAllRatingsByUserId(user.getId());

        model.addAttribute("user", user);

        return "userEdit";
    }

    @PostMapping("user/{userId}/edit")
    public String userSave(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String userName,
            @RequestParam("userId") User user,
            @PathVariable Long userId) {
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(userName);

        userRepository.save(user);

        return "redirect:/user/{userId}";
    }
}

