package com.usmteam3.votingapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestMainPageController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
