package com.usmteam3.votingapp.service.impl;

import com.usmteam3.votingapp.dao.CoffeeShopRepository;
import com.usmteam3.votingapp.model.CoffeeShop;
import com.usmteam3.votingapp.service.CoffeeShopService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CoffeeShopServiceImpl implements CoffeeShopService {

    private final CoffeeShopRepository coffeeShopRepository;

    public void addNewCoffeeShop(CoffeeShop coffeeShop) {
        coffeeShopRepository.save(coffeeShop);
    }

    public List<CoffeeShop> getAllCoffeeShops() {
        return coffeeShopRepository.findAll();
    }

    public Optional<CoffeeShop> getCoffeeShopById(Long coffeeShopId) {
        return coffeeShopRepository.findById(coffeeShopId);
    }

}
