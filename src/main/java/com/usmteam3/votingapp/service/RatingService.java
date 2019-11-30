package com.usmteam3.votingapp.service;

import com.usmteam3.votingapp.model.Rating;

import java.util.List;

public interface RatingService  {

    void addRating(Rating rating);

    Double getAvgRating(Long coffeeShopId);

    List<Rating> getAllRatingsByUserId(Long userId);

}
