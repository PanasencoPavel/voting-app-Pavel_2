package com.usmteam3.votingapp.controller;

import com.usmteam3.votingapp.model.CoffeeShop;
import com.usmteam3.votingapp.model.Feedback;
import com.usmteam3.votingapp.model.Rating;
import com.usmteam3.votingapp.model.User;
import com.usmteam3.votingapp.service.impl.CoffeeShopServiceImpl;
import com.usmteam3.votingapp.service.impl.RatingServiceImpl;
import com.usmteam3.votingapp.util.NoteConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Optional;

@Controller
public class CoffeeShopController {

    @Autowired
    private CoffeeShopServiceImpl coffeeShopService;

    @Autowired
    private RatingServiceImpl ratingService;

    @GetMapping("/shop/{id}")
    public String coffeePage(@PathVariable Long id, Map<String, Object> model) {
        CoffeeShop coffeeShop = coffeeShopService.getCoffeeShopById(id).get();
        Iterable<Rating> ratings = ratingService.getAllRatingsByCoffeeShopId(id);
        Double avgRaiting = ratingService.getAvgRating(id);
        Double avgCoffee = ratingService.getAvgCoffeeRating(id);
        Double avgS = ratingService.getAvgServiceRating(id);
        Double avgF = ratingService.getAvgAtmosphereRating(id);
        Double avgA = ratingService.getAvgFoodRating(id);

        model.put("avgCoffee",avgCoffee);
        model.put("avgS",avgS);
        model.put("avgF",avgF);
        model.put("avgA",avgA);

        model.put("avg", avgRaiting);
        model.put("ratings", ratings);
        model.put("coffeeShop", coffeeShop);

        return "coffee";
    }

    @GetMapping("/shop/{id}/addrating")
    public String addRating(@PathVariable Long id, Map<String, Object> model) {
        Optional<CoffeeShop> coffeeShop = coffeeShopService.getCoffeeShopById(id);

        model.put("coffeeShop", coffeeShop);

        return "addrating";
    }

    @PostMapping("/shop/{id}/addrating")
    public String addRating(
            @PathVariable Long id,
            @AuthenticationPrincipal User user,
            @RequestParam String headingText,
            @RequestParam String feedbackText,
            @RequestParam Integer coffeeNote,
            @RequestParam Integer foodNote,
            @RequestParam Integer atmosphereNote,
            @RequestParam Integer serviceNote,
            Map<String, Object> model) {

        CoffeeShop coffeeShop1 = coffeeShopService.getCoffeeShopById(id).get();

        Feedback feedback = new Feedback();
        feedback.setFeedbackText(feedbackText);
        feedback.setCoffeeShop(coffeeShop1);
        feedback.setFeedbackText(feedbackText);
        feedback.setHeadingText(headingText);
        feedback.setUser(user);

        NoteConverter noteConverter = new NoteConverter();
        Rating rating = new Rating();
        rating.setCoffeeShop(coffeeShop1);
        rating.setUser(user);
        rating.setCoffeeNote(noteConverter.convertToEntityAttribute(coffeeNote));
        rating.setFoodNote(noteConverter.convertToEntityAttribute(foodNote));
        rating.setAtmosphereNote(noteConverter.convertToEntityAttribute(atmosphereNote));
        rating.setServiceNote(noteConverter.convertToEntityAttribute(serviceNote));
        rating.setFeedback(feedback);
        ratingService.addRating(rating);

        Iterable<Rating> ratings = ratingService.getAllRatingsByCoffeeShopId(id);

        model.put("ratings", ratings);
        model.put("coffeeShop", coffeeShop1);

        return "redirect:/shop/{id}";
    }

}
