package com.sachinsk.foodcatalogue.service;

import com.sachinsk.foodcatalogue.repo.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodCatalogueService {

    @Autowired
    FoodItemRepo foodItemRepo;
}
