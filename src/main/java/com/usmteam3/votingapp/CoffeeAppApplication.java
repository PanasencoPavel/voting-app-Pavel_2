package com.usmteam3.votingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CoffeeAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeeAppApplication.class, args);
    }

}
