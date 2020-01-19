package com.usmteam3.votingapp.service.impl;

import com.usmteam3.votingapp.dao.FeedbackRepository;
import com.usmteam3.votingapp.model.Feedback;
import com.usmteam3.votingapp.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Transactional
    public void addFeedback(Feedback feedback) {
        feedbackRepository.save(feedback);
    }

    @Transactional
    public List<Feedback> getAllFeedbackByUserId(Long userId) {
        return feedbackRepository.getAllFeedbackByUserId(userId);
    }

    @Transactional
    public List<Feedback> getAllFeedbackByCoffeeShopId(Long coffeeShopId) {
        return feedbackRepository.getAllFeedbackByCoffeeShopId(coffeeShopId);
    }
}
