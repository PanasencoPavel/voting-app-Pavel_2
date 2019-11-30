package com.usmteam3.votingapp.service.impl;

import com.usmteam3.votingapp.dao.UserRepository;
import com.usmteam3.votingapp.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private static final String NAME = "UserName";
    private static final String MAIL = "user@gmail.com";


    @Test
    public void AddNewUserTest() {
        //Arrange
        User user = new User();
        user.setId(1L);
        user.setFirstName(NAME);
        user.setEmail(MAIL);

        //Act
        userService.addNewUser(user);

        //Assert
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void GetAllUsersTest() {

        User user = new User();
        user.setId(1L);
        user.setFirstName(NAME);
        user.setEmail(MAIL);
        userService.addNewUser(user);

        List<User> expectedUserList = new ArrayList<>();
        expectedUserList.add(user);

        //Act
        when(userRepository.findAll()).thenReturn(expectedUserList);

        List<User> returnedUserList = userService.getAllUsers();

        //Assert
        verify(userRepository, times(1)).findAll();
        verify(userRepository, times(1)).save(user);


    }

    @Test
    public void GetByCoffeeShopIdTest() {
        User user = new User();
        user.setId(1L);
        user.setFirstName(NAME);
        user.setEmail(MAIL);
        userService.addNewUser(user);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User returnedUser = userService.getUserById(1L).get();

        verify(userRepository, times(1)).findById(returnedUser.getId());
        verify(userRepository, times(1)).save(user);
        Assert.assertNotNull(returnedUser);

    }
}