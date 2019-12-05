package com.usmteam3.votingapp.controller;

import com.usmteam3.votingapp.dao.FeedbackRepository;
import com.usmteam3.votingapp.dao.RatingRepository;
import com.usmteam3.votingapp.model.Feedback;
import com.usmteam3.votingapp.service.impl.RatingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    RatingServiceImpl ratingRepository;

    @Autowired
    FeedbackRepository feedbackRepository;

    @GetMapping("/")
    public String greeting() {
        return "home";
    }

    @GetMapping("/main")
    public String mainPage(Map<String, Object> model) {
        Iterable<Feedback> feedbacks = feedbackRepository.findAll();

        model.put("feedbacks", feedbacks);

        return "main";
    }


}
