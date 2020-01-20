package com.usmteam3.votingapp.controller;

import com.usmteam3.votingapp.dto.CoffeeShopDto;
import com.usmteam3.votingapp.model.CoffeeShop;
import com.usmteam3.votingapp.service.impl.CoffeeShopServiceImpl;
import com.usmteam3.votingapp.service.impl.RatingServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private CoffeeShopServiceImpl coffeeShopService;

    @Autowired
    private RatingServiceImpl ratingService;

    @GetMapping("/")
    public String greeting() {
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String mainPage(Map<String, Object> model) {
        Iterable<CoffeeShop> coffeeShop = coffeeShopService.getAllCoffeeShops();

        ModelMapper modelMapper = new ModelMapper();
        List<CoffeeShopDto> list = new ArrayList<>();

        for (CoffeeShop shop : coffeeShop
        ) {
            CoffeeShopDto coffeeShopDto = new CoffeeShopDto();
            modelMapper.map(shop, coffeeShopDto);
            coffeeShopDto.setAvg(ratingService.getAvgRating(shop.getId()));
            list.add(coffeeShopDto);
        }

        model.put("coffeeShop", list);

        return "main";
    }
}
