package com.usmteam3.votingapp.service;


import com.usmteam3.votingapp.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void addNewUser(User user);
}

