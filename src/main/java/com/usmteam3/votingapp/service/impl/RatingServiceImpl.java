package com.usmteam3.votingapp.service.impl;

import com.usmteam3.votingapp.dao.FeedbackRepository;
import com.usmteam3.votingapp.dao.RatingRepository;
import com.usmteam3.votingapp.model.Rating;
import com.usmteam3.votingapp.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;

    private final FeedbackRepository feedbackRepository;

    @Transactional
    public void addRating(Rating rating) {
        feedbackRepository.save(rating.getFeedback());
        ratingRepository.save(rating);
    }

    @Transactional
    public Double getAvgRating(Long coffeeShopId) {
        return ratingRepository.getAvgRating(coffeeShopId);
    }

    @Transactional
    public Double getAvgFoodRating(Long coffeeShopId) { return ratingRepository.getAvgFoodRating(coffeeShopId); }

    @Transactional
    public Double getAvgAtmosphereRating(Long coffeeShopId) { return ratingRepository.getAvgAtmosphereRating(coffeeShopId); }

    @Transactional
    public Double getAvgServiceRating(Long coffeeShopId) { return ratingRepository.getAvgServiceRating(coffeeShopId); }

    @Transactional
    public Double getAvgCoffeeRating(Long coffeeShopId) { return ratingRepository.getAvgCoffeeRating(coffeeShopId); }

    @Transactional
    public List<Rating> getAllRatingsByUserId(Long userId) {
        return ratingRepository.getAllRatingsByUserId(userId);
    }

    @Transactional
    public List<Rating> getAllRatingsByCoffeeShopId(Long coffeeShopId) {
        return ratingRepository.getAllByCoffeeShopId(coffeeShopId);
    }

}
