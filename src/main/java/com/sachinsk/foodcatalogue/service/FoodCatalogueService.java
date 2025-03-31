package com.sachinsk.foodcatalogue.service;

import com.sachinsk.foodcatalogue.dto.FoodCataloguePage;
import com.sachinsk.foodcatalogue.dto.FoodItemDTO;
import com.sachinsk.foodcatalogue.dto.Restaurant;
import com.sachinsk.foodcatalogue.entity.FoodItem;
import com.sachinsk.foodcatalogue.mapper.FoodItemMapper;
import com.sachinsk.foodcatalogue.repo.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodCatalogueService {

    @Autowired
    FoodItemRepo foodItemRepo;

    @Autowired
    RestTemplate restTemplate;

    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
        FoodItem foodItemSavedInDB = foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO));

        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDTO(foodItemSavedInDB);
    }

    public FoodCataloguePage fetchFoodCataloguePageDetails(Integer restaurantId) {

        //food item list
        List<FoodItem> foodItemList = fetchFoodItemList(restaurantId);
        //restaurant details
        Restaurant restaurantDTO = fetchRestaurantDetailsFromRestaurantMS(restaurantId);

        FoodCataloguePage resultFoodCataloguePage = createFoodCataloguePage(foodItemList, restaurantDTO);
        return resultFoodCataloguePage;
    }

    private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {

        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        foodCataloguePage.setFoodItemList(foodItemList);
        foodCataloguePage.setRestaurant(restaurant);

        return foodCataloguePage;

    }

    private Restaurant fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId) {

        //We need RestTemplate to fetch the details from another microservice
       // Note: we will be referring the restaurant listing service's control to find which method returns the details by ID -> in our case is "/fetchById/{id}"
        Restaurant restaurant = restTemplate.getForObject("http://RESTAURANT-SERVICE/fetchById/" +restaurantId, Restaurant.class);
        return restaurant;

    }

    private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
        List<FoodItem> foodItemListById = foodItemRepo.findByRestaurantId(restaurantId);
        return foodItemListById;
    }
}
