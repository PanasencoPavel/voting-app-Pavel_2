package com.usmteam3.votingapp.dao;

import com.usmteam3.votingapp.model.CoffeeShop;
import com.usmteam3.votingapp.model.Rating;
import com.usmteam3.votingapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Query(value = "SELECT avg((e.coffeeNote + e.foodNote + e.serviceNote + e.atmosphereNote)/4) FROM Rating e WHERE e.coffeeShop = :coffeeShop")
    Double getAvgRating(@Param("coffeeShop") CoffeeShop coffeeShop);

    @Query(value = "SELECT r FROM Rating r WHERE r.user = :user")
    List<Rating> getAllRatingsByUserId(@Param("user")User user);

}
