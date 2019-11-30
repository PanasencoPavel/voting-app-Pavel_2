package com.usmteam3.votingapp.service.impl;

import com.usmteam3.votingapp.dao.CoffeeShopRepository;
import com.usmteam3.votingapp.dao.RatingRepository;
import com.usmteam3.votingapp.dao.UserRepository;
import com.usmteam3.votingapp.model.CoffeeShop;
import com.usmteam3.votingapp.model.Rating;
import com.usmteam3.votingapp.model.User;
import com.usmteam3.votingapp.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;
    private final CoffeeShopRepository coffeeShopRepository;
    private final UserRepository userRepository;

    @Transactional
    public void addRating(Rating rating) {
        ratingRepository.save(rating);
    }

    @Transactional
    public Double getAvgRating(Long coffeeShopId) {
        Optional<CoffeeShop> coffeeShop = coffeeShopRepository.findById(coffeeShopId);
        return ratingRepository.getAvgRating(coffeeShop.get());
    }

    public List<Rating> getAllRatingsByUserId(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return ratingRepository.getAllRatingsByUserId(user.get());
    }

}
