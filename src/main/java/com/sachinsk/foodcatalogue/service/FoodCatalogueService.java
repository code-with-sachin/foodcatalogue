package com.sachinsk.foodcatalogue.service;

import com.sachinsk.foodcatalogue.dto.FoodCataloguePage;
import com.sachinsk.foodcatalogue.dto.FoodItemDTO;
import com.sachinsk.foodcatalogue.dto.Restaurant;
import com.sachinsk.foodcatalogue.entity.FoodItem;
import com.sachinsk.foodcatalogue.mapper.FoodItemMapper;
import com.sachinsk.foodcatalogue.repo.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodCatalogueService {

    @Autowired
    FoodItemRepo foodItemRepo;

    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
        FoodItem foodItemSavedInDB = foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO));

        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDTO(foodItemSavedInDB);
    }

    public FoodCataloguePage fetchFoodCataloguePageDetails(Integer restaurantId) {

        //food item list
        List<FoodItem> foodItemList = fetchFoodItemList(restaurantId);
        //restaurant details
        Restaurant restaurantDTO = fetchRestaurantDetailsFromRestaurantMS(restaurantId);

        createFoodCataloguePage(foodItemList, restaurantDTO);
    }

    private void createFoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurantDTO) {
    }

    private Restaurant fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId) {
    }

    private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
        return foodItemRepo.findByRestaurantId(restaurantId);
    }
}
