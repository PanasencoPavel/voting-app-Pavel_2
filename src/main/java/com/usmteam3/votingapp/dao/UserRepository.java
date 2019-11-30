package com.usmteam3.votingapp.dao;

import com.usmteam3.votingapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
