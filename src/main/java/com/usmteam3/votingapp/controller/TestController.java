package com.usmteam3.votingapp.controller;

import com.usmteam3.votingapp.model.Rating;
import com.usmteam3.votingapp.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    private final RatingService ratingService;

    @Autowired
    public TestController(final RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping(value = "/testAverage/{id}")
    public Double testAverage(@PathVariable Long id) {
        return ratingService.getAvgRating(id);
    }

    @GetMapping(value = "/testRatings/{id}")
    public List<Rating> testAllRatingsByUserId(@PathVariable Long id) {
        return ratingService.getAllRatingsByUserId(id);
    }
}
