package com.sachinsk.foodcatalogue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    //This will be a DTO to FoodCataloguePage DTO to fetch restaurant details

    //copy the field from Restaurant Microservice entity class
    private int restaurantId;
    private String restaurantName;
    private String address;
    private String city;
    private String restaurantDescription;
}
