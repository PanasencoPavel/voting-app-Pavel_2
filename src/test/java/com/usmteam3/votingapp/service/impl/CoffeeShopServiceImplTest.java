package com.usmteam3.votingapp.service.impl;

import com.usmteam3.votingapp.dao.CoffeeShopRepository;
import com.usmteam3.votingapp.model.CoffeeShop;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CoffeeShopServiceImplTest {

    @Mock
    private CoffeeShopRepository coffeeShopRepository;

    @InjectMocks
    private CoffeeShopServiceImpl coffeeShopService;

    @After
    public void tearDown() {
        verifyNoMoreInteractions(coffeeShopRepository);
    }

    private static final String NAME = "Tucano";
    private static final String ADDRESS = "Stefan cel Mare 3";


    @Test
    public void AddNewCoffeeShopTest() {
        //Arrange
        CoffeeShop coffeeShop = new CoffeeShop();
        coffeeShop.setId(1L);
        coffeeShop.setName(NAME);
        coffeeShop.setAddress(ADDRESS);

        //Act
        coffeeShopService.addNewCoffeeShop(coffeeShop);

        //Assert
        verify(coffeeShopRepository, times(1)).save(coffeeShop);

    }

    @Test
    public void GetAllCoffeeShopsTest() {

        CoffeeShop coffeeShop = new CoffeeShop();
        coffeeShop.setId(1L);
        coffeeShop.setName(NAME);
        coffeeShop.setAddress(ADDRESS);
        coffeeShopService.addNewCoffeeShop(coffeeShop);

        List<CoffeeShop> expectedCoffeeShopList = new ArrayList<>();
        expectedCoffeeShopList.add(coffeeShop);

        //Act
        when(coffeeShopRepository.findAll()).thenReturn(expectedCoffeeShopList);

        List<CoffeeShop> returnedCoffeeShopList = coffeeShopService.getAllCoffeeShops();

        //Assert
        verify(coffeeShopRepository, times(1)).findAll();
        verify(coffeeShopRepository, times(1)).save(coffeeShop);
        assertThat(returnedCoffeeShopList.size()).isEqualTo(1);

    }

    @Test
    public void GetByCoffeeShopIdTest() {
        CoffeeShop coffeeShop = new CoffeeShop();
        coffeeShop.setId(1L);
        coffeeShopService.addNewCoffeeShop(coffeeShop);

        when(coffeeShopRepository.findById(1L)).thenReturn(Optional.of(coffeeShop));

        CoffeeShop returnedCoffeeShop = coffeeShopService.getCoffeeShopById(1L).get();

        verify(coffeeShopRepository, times(1)).findById(returnedCoffeeShop.getId());
        verify(coffeeShopRepository, times(1)).save(coffeeShop);
        assertThat(returnedCoffeeShop).isNotNull();

    }
}
