package com.usmteam3.votingapp.dao;

import com.usmteam3.votingapp.model.CoffeeShop;
import com.usmteam3.votingapp.model.Feedback;
import com.usmteam3.votingapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    @Query(value = "SELECT f FROM Feedback f inner join f.user u WHERE u.id = :userId")
    List<Feedback> getAllFeedbackByUserId(@Param("userId") Long userId);

    @Query(value = "SELECT f FROM Feedback f inner join f.coffeeShop c WHERE c.id = :coffeeShopId")
    List<Feedback> getAllFeedbackByCoffeeShopId(@Param("coffeeShopId") Long coffeeShopId);
}
