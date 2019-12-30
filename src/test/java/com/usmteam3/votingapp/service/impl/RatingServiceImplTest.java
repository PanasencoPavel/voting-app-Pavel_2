package com.usmteam3.votingapp.service.impl;

import com.usmteam3.votingapp.dao.CoffeeShopRepository;
import com.usmteam3.votingapp.dao.RatingRepository;
import com.usmteam3.votingapp.dao.UserRepository;
import com.usmteam3.votingapp.model.CoffeeShop;
import com.usmteam3.votingapp.model.Rating;
import com.usmteam3.votingapp.model.User;
import com.usmteam3.votingapp.model.enums.Note;
import com.usmteam3.votingapp.util.NoteConverter;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RatingServiceImplTest {
//
//    @Mock
//    private RatingRepository ratingRepository;
//
//    @Mock
//    private CoffeeShopRepository coffeeShopRepository;
//
//    @Mock
//    private UserRepository userRepository;
//
//    @InjectMocks
//    private RatingServiceImpl ratingService;
//
//    @After
//    public void tearDown() {
//        verifyNoMoreInteractions(ratingRepository);
//    }
//
//    @Test
//    public void addRatingTest() {
//        //Arrange
//        User user = new User();
//        CoffeeShop coffeeShop = new CoffeeShop();
//        Rating rating = new Rating();
//        rating.setCoffeeShop(coffeeShop);
//        rating.setUser(user);
//        //Act
//        ratingService.addRating(rating);
//        //Assert
//        verify(ratingRepository, times(1)).save(rating);
//        assertThat(ratingRepository).isNotNull();
//    }
//
//    @Test
//    public void testGetAvgRatingTest() {
//        User user = new User();
//        CoffeeShop coffeeShop = new CoffeeShop();
//        coffeeShop.setId(1L);
//        Rating rating = new Rating();
//        rating.setUser(user);
//        rating.setCoffeeShop(coffeeShop);
//        rating.setUser(user);
//        NoteConverter noteConverter = new NoteConverter();
//        rating.setCoffeeNote(noteConverter.convertToEntityAttribute(5));
//        rating.setFoodNote(Note.FIVE);
//        rating.setAtmosphereNote(Note.FIVE);
//        rating.setServiceNote(Note.FIVE);
//        ratingRepository.save(rating);
//
//        Double expectedRepositoryAvgRating = 4.5;
//
////        when(coffeeShopRepository.findById(1L)).thenReturn(Optional.of(coffeeShop));
//        when(ratingRepository.getAvgRating(coffeeShop.getId())).thenReturn(expectedRepositoryAvgRating);
//
//        Double returnedAvgRating = ratingService.getAvgRating(1L);
//
//        assertThat(returnedAvgRating).isNotNull();
//        assertThat(expectedRepositoryAvgRating).isEqualTo(returnedAvgRating);
//
//        verify(ratingRepository, times(1)).getAvgRating(coffeeShop.getId());
//        verify(ratingRepository, times(1)).save(rating);
//    }
//
//    @Test
//    public void getAllRatingsByUserIdTest() {
//        User user = new User();
//        user.setId(1L);
//        CoffeeShop coffeeShop = new CoffeeShop();
//        Rating rating = new Rating();
//        rating.setUser(user);
//        rating.setCoffeeShop(coffeeShop);
//        rating.setUser(user);
//        rating.setCoffeeNote(Note.FIVE);
//        rating.setFoodNote(Note.FIVE);
//        rating.setAtmosphereNote(Note.FIVE);
//        rating.setServiceNote(Note.FIVE);
//
//        ratingService.addRating(rating);
//        List<Rating> expectedRatingList = new ArrayList<>();
//        expectedRatingList.add(rating);
//
////        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
//        when(ratingRepository.getAllRatingsByUserId(user.getId())).thenReturn(expectedRatingList);
//
//        List<Rating> returnedRatingList = ratingService.getAllRatingsByUserId(1L);
//
//        verify(ratingRepository, times(1)).getAllRatingsByUserId(user.getId());
//        verify(ratingRepository, times(1)).save(rating);
//
//        assertThat(returnedRatingList).isNotNull();
//        assertThat(returnedRatingList.size()).isEqualTo(1);
//    }

}