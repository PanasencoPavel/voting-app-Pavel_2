package com.usmteam3.votingapp.service.impl;

import com.usmteam3.votingapp.dao.CoffeeShopRepository;
import com.usmteam3.votingapp.dao.FeedbackRepository;
import com.usmteam3.votingapp.dao.UserRepository;
import com.usmteam3.votingapp.model.CoffeeShop;
import com.usmteam3.votingapp.model.Feedback;
import com.usmteam3.votingapp.model.User;
import com.usmteam3.votingapp.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {
    private final CoffeeShopRepository coffeeShopRepository;
    private final FeedbackRepository feedbackRepository;
    private final UserRepository userRepository;

    @Transactional
    public void addFeedback(Feedback feedback) {
        feedbackRepository.save(feedback);
    }

    public List<Feedback> getAllFeedbackByUserId(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return feedbackRepository.getAllFeedbackByUserId(user.get());
    }

    public List<Feedback> getAllFeedbackByCoffeeShopId(Long coffeeShopId) {
        Optional<CoffeeShop> coffeeShop = coffeeShopRepository.findById(coffeeShopId);
        return feedbackRepository.getAllFeedbackByCoffeeShopId(coffeeShop.get());
    }
}
