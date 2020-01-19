package com.usmteam3.votingapp.controller;

import com.usmteam3.votingapp.dto.ShopRaitingDto;
import com.usmteam3.votingapp.model.CoffeeShop;
import com.usmteam3.votingapp.model.Feedback;
import com.usmteam3.votingapp.model.Rating;
import com.usmteam3.votingapp.model.User;
import com.usmteam3.votingapp.service.impl.CoffeeShopServiceImpl;
import com.usmteam3.votingapp.service.impl.RatingServiceImpl;
import com.usmteam3.votingapp.util.NoteConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@Controller
public class CoffeeShopController {

    @Autowired
    private CoffeeShopServiceImpl coffeeShopService;

    @Autowired
    private RatingServiceImpl ratingService;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/shop/{id}")
    public String coffeePage(@PathVariable Long id, Map<String, Object> model) {
        CoffeeShop coffeeShop = coffeeShopService.getCoffeeShopById(id).get();
        Iterable<Rating> ratings = ratingService.getAllRatingsByCoffeeShopId(id);

        ModelMapper modelMapper = new ModelMapper();
        ShopRaitingDto shop = new ShopRaitingDto();
        modelMapper.map(coffeeShop, shop);
        shop.setAvgCoffee(ratingService.getAvgCoffeeRating(id));
        shop.setAvgFood(ratingService.getAvgFoodRating(id));
        shop.setAvgAtmosphere(ratingService.getAvgAtmosphereRating(id));
        shop.setAvgService(ratingService.getAvgServiceRating(id));
        shop.setAvg(ratingService.getAvgRating(id));

        model.put("ratings", ratings);
        model.put("coffeeShop", shop);

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
            @RequestParam Map<String, Object> model,
            @RequestParam("file") MultipartFile file) throws IOException {

        CoffeeShop coffeeShop1 = coffeeShopService.getCoffeeShopById(id).get();

        Feedback feedback = Feedback.builder()
                .feedbackText(feedbackText)
                .headingText(headingText)
                .coffeeShop(coffeeShop1)
                .user(user)
                .build();

        NoteConverter noteConverter = new NoteConverter();
        Rating rating = Rating.builder()
                .coffeeShop(coffeeShop1)
                .user(user)
                .feedback(feedback)
                .coffeeNote(noteConverter.convertToEntityAttribute(coffeeNote))
                .foodNote(noteConverter.convertToEntityAttribute(foodNote))
                .atmosphereNote(noteConverter.convertToEntityAttribute(atmosphereNote))
                .serviceNote(noteConverter.convertToEntityAttribute(serviceNote))
                .build();

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadFile = new File(uploadPath);
            if (!uploadFile.exists()) {
                uploadFile.mkdir();
            }
            file.transferTo(new File(uploadPath + "/" + file.getOriginalFilename()));
            rating.setFilename(file.getOriginalFilename());
        }

        ratingService.addRating(rating);
        Iterable<Rating> ratings = ratingService.getAllRatingsByCoffeeShopId(id);

        model.put("ratings", ratings);
        model.put("coffeeShop", coffeeShop1);

        return "redirect:/shop/{id}";
    }
}
