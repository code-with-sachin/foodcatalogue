package com.sachinsk.foodcatalogue.controller;

import com.sachinsk.foodcatalogue.dto.FoodCataloguePage;
import com.sachinsk.foodcatalogue.dto.FoodItemDTO;
import com.sachinsk.foodcatalogue.service.FoodCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodCatalogue")
public class FoodCatalogueController {

    @Autowired
    FoodCatalogueService foodCatalogueService;

    @PostMapping("/addFoodItem")
    public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO foodItemDTO) {
        FoodItemDTO savedFoodItem = foodCatalogueService.addFoodItem(foodItemDTO);
        return new ResponseEntity<>(savedFoodItem, HttpStatus.CREATED);
    }

    @GetMapping("/fetchRestaurantAndFoodItemsById/{id}")
    public ResponseEntity<FoodCataloguePage> fetchRestaurantDetailsWithFoodMenu(@PathVariable(value = "id") Integer restaurantId) {
        FoodCataloguePage fetchedFoodCataloguePage = foodCatalogueService.fetchFoodCataloguePageDetails(restaurantId);
        if (fetchedFoodCataloguePage != null) {
            return new ResponseEntity<>(fetchedFoodCataloguePage, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
