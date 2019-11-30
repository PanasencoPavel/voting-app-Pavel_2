package com.usmteam3.votingapp.dao;

import com.usmteam3.votingapp.model.CoffeeShop;
import com.usmteam3.votingapp.model.Feedback;
import com.usmteam3.votingapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    @Query(value = "SELECT r FROM Feedback r WHERE r.user = :user")
    List<Feedback> getAllFeedbackByUserId(@Param("user") User user);

    @Query(value = "SELECT r FROM Feedback r WHERE r.coffeeShop = :coffee_shop")
    List<Feedback> getAllFeedbackByCoffeeShopId(@Param("coffee_shop") CoffeeShop coffeeShop);
}
