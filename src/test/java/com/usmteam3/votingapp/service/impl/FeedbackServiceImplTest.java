package com.usmteam3.votingapp.service.impl;

import com.usmteam3.votingapp.dao.FeedbackRepository;
import com.usmteam3.votingapp.model.CoffeeShop;
import com.usmteam3.votingapp.model.Feedback;
import com.usmteam3.votingapp.model.User;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class FeedbackServiceImplTest {

    @Mock
    private FeedbackRepository feedbackRepository;

    @InjectMocks
    private FeedbackServiceImpl feedbackService;

    @After
    public void tearDown() {
        verifyNoMoreInteractions(feedbackRepository);
    }

    @Test
    public void addFeedbackTest() {
        User user = new User();
        CoffeeShop coffeeShop = new CoffeeShop();
        Feedback feedback = new Feedback();
        feedback.setCoffeeShop(coffeeShop);
        feedback.setUser(user);
        feedback.setHeadingText("head text");
        feedback.setFeedbackText("feedback text");

        feedbackService.addFeedback(feedback);

        verify(feedbackRepository, times(1)).save(feedback);
        assertThat(feedbackRepository).isNotNull();
    }

    @Test
    public void getAllFeedbackByUserIdTest() {
        User user = new User();
        user.setId(1L);
        CoffeeShop coffeeShop = new CoffeeShop();
        Feedback feedback = new Feedback();
        feedback.setCoffeeShop(coffeeShop);
        feedback.setUser(user);
        feedback.setHeadingText("head text");
        feedback.setFeedbackText("feedback text");

        feedbackService.addFeedback(feedback);
        List<Feedback> expectedFeedbackList = new ArrayList<>();
        expectedFeedbackList.add(feedback);

        when(feedbackRepository.getAllFeedbackByUserId(user.getId())).thenReturn(expectedFeedbackList);

        List<Feedback> returnedFeedbackList = feedbackService.getAllFeedbackByUserId(1L);

        verify(feedbackRepository, times(1)).getAllFeedbackByUserId(user.getId());
        verify(feedbackRepository, times(1)).save(feedback);

        assertThat(returnedFeedbackList).isNotNull();
        assertThat(returnedFeedbackList.size()).isEqualTo(1);
    }

    @Test
    public void getAllFeedbackByCoffeeShopIdTest() {
        User user = new User();
        CoffeeShop coffeeShop = new CoffeeShop();
        coffeeShop.setId(1L);
        Feedback feedback = new Feedback();
        feedback.setCoffeeShop(coffeeShop);
        feedback.setUser(user);
        feedback.setHeadingText("head text");
        feedback.setFeedbackText("feedback text");

        feedbackService.addFeedback(feedback);
        List<Feedback> expectedFeedbackList = new ArrayList<>();
        expectedFeedbackList.add(feedback);

        when(feedbackRepository.getAllFeedbackByCoffeeShopId(coffeeShop.getId())).thenReturn(expectedFeedbackList);

        List<Feedback> returnedFeedbackList = feedbackService.getAllFeedbackByCoffeeShopId(1L);

        verify(feedbackRepository, times(1)).getAllFeedbackByCoffeeShopId(coffeeShop.getId());
        verify(feedbackRepository, times(1)).save(feedback);

        assertThat(returnedFeedbackList).isNotNull();
        assertThat(returnedFeedbackList.size()).isEqualTo(1);
    }
}

