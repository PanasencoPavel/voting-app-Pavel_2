package com.usmteam3.votingapp.service.impl;

import com.usmteam3.votingapp.dao.CoffeeShopRepository;
import com.usmteam3.votingapp.dao.RatingRepository;
import com.usmteam3.votingapp.model.CoffeeShop;
import com.usmteam3.votingapp.service.CoffeeShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoffeeShopServiceImpl implements CoffeeShopService {

    private final CoffeeShopRepository coffeeShopRepository;

    @Transactional
    public void addNewCoffeeShop(CoffeeShop coffeeShop) {
        coffeeShopRepository.save(coffeeShop);
    }

    @Transactional
    public List<CoffeeShop> getAllCoffeeShops() {
        return coffeeShopRepository.findAll();
    }

    @Transactional
    public Optional<CoffeeShop> getCoffeeShopById(Long coffeeShopId) {
        Optional<CoffeeShop> coffeeShop = coffeeShopRepository.findById(coffeeShopId);
        return  coffeeShop;
    }


}
