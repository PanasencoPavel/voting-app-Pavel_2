package com.usmteam3.votingapp.dto;

import lombok.Data;

@Data
public class ShopRaitingDto {

        private String id;

        private String name;

        private String address;

        private String description;

        private String filename;

        private Double avg;

        private Double avgCoffee;

        private Double avgFood;

        private Double avgAtmosphere;

        private Double avgService;

    }
