package com.restaurant.foodcatalogue.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.restaurant.foodcatalogue.dto.FoodCataloguePageDTO;
import com.restaurant.foodcatalogue.dto.FoodItemDTO;
import com.restaurant.foodcatalogue.dto.RestaurantDTO;
import com.restaurant.foodcatalogue.entity.FoodItem;
import com.restaurant.foodcatalogue.mapper.FoodItemMapper;
import com.restaurant.foodcatalogue.repo.FoodItemRepo;

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

    public FoodCataloguePageDTO fetchFoodCataloguePageDetails(Integer restaurantId) {
        List<FoodItemDTO> foodItemDTOList =  fetchFoodItemList(restaurantId);
        RestaurantDTO restaurantDTO = fetchRestaurantDetailsFromRestaurantMS(restaurantId);
        return createFoodCataloguePage(foodItemDTOList, restaurantDTO);
    }

    private FoodCataloguePageDTO createFoodCataloguePage(List<FoodItemDTO> foodItemDTOList, RestaurantDTO restaurantDTO) {
        FoodCataloguePageDTO foodCataloguePageDTO = new FoodCataloguePageDTO();
        foodCataloguePageDTO.setFoodItemsDTOList(foodItemDTOList);
        foodCataloguePageDTO.setRestaurantDTO(restaurantDTO);
        return foodCataloguePageDTO;
    }

    private RestaurantDTO fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId) {
       return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchById/"+restaurantId, RestaurantDTO.class);
    }

    private List<FoodItemDTO> fetchFoodItemList(Integer restaurantId) {
    	return FoodItemMapper.INSTANCE.mapFoodItemListToFoodItemDTOList(foodItemRepo.findByRestaurantId(restaurantId));
    }
}
