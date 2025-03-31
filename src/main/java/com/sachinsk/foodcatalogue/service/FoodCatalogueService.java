package com.sachinsk.foodcatalogue.service;

import com.sachinsk.foodcatalogue.dto.FoodCataloguePage;
import com.sachinsk.foodcatalogue.dto.FoodItemDTO;

public interface FoodCatalogueService {

    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO);

    public FoodCataloguePage fetchFoodCataloguePageDetails(Integer restaurantId);

}
