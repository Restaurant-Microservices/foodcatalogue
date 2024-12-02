package com.restaurant.foodcatalogue.mapper;


import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.restaurant.foodcatalogue.dto.FoodItemDTO;
import com.restaurant.foodcatalogue.entity.FoodItem;

@Mapper
public interface FoodItemMapper {

    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);

    FoodItem mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO);

    FoodItemDTO mapFoodItemToFoodItemDTO(FoodItem foodItem);
    
    List<FoodItemDTO> mapFoodItemListToFoodItemDTOList(List<FoodItem> list);


}
