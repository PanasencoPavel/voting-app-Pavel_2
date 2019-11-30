package com.usmteam3.votingapp.service;

import com.usmteam3.votingapp.model.Feedback;

import java.util.List;

public interface FeedbackService {

    void addFeedback(Feedback feedback);

    List<Feedback> getAllFeedbackByUserId(Long userId);

    List<Feedback> getAllFeedbackByCoffeeShopId(Long coffeeShopId);

}
