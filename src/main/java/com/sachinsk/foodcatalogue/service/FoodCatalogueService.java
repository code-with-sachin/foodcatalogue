package com.sachinsk.foodcatalogue.service;

import com.sachinsk.foodcatalogue.dto.FoodItemDTO;
import com.sachinsk.foodcatalogue.entity.FoodItem;
import com.sachinsk.foodcatalogue.mapper.FoodItemMapper;
import com.sachinsk.foodcatalogue.repo.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodCatalogueService {

    @Autowired
    FoodItemRepo foodItemRepo;

    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
        FoodItem foodItemSavedInDB = foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO));

        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDTO(foodItemSavedInDB);
    }
}
