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

    @Query(value = "SELECT avg((r.coffeeNote + r.foodNote + r.serviceNote + r.atmosphereNote)/4.0) FROM Rating r " +
            "inner join r.coffeeShop c WHERE c.id = :coffeeShopId")
    Double getAvgRating(@Param("coffeeShopId") Long coffeeShopId);

    @Query(value = "SELECT r FROM Rating r inner join r.user u WHERE u.id = :userId")
    List<Rating> getAllRatingsByUserId(@Param("userId") Long userId);

    List<Rating> getAllByCoffeeShopId(Long id);

    @Query(value = "SELECT avg(r.coffeeNote) FROM Rating r inner join r.coffeeShop c where c.id = :coffeeShopId")
    Double getAvgCoffeeRating(@Param("coffeeShopId") Long coffeeShopId);

    @Query(value = "SELECT avg(r.foodNote) FROM Rating r inner join r.coffeeShop c where c.id = :coffeeShopId")
    Double getAvgFoodRating(@Param("coffeeShopId") Long coffeeShopId);

    @Query(value = "SELECT avg(r.atmosphereNote) FROM Rating r inner join r.coffeeShop c where c.id = :coffeeShopId")
    Double getAvgAtmosphereRating(@Param("coffeeShopId") Long coffeeShopId);

    @Query(value = "SELECT avg(r.serviceNote) FROM Rating r inner join r.coffeeShop c where c.id = :coffeeShopId")
    Double getAvgServiceRating(@Param("coffeeShopId") Long coffeeShopId);

}
