package com.restaurant.foodcatalogue.mapper;

import com.restaurant.foodcatalogue.dto.FoodItemDTO;
import com.restaurant.foodcatalogue.entity.FoodItem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-04T22:38:48+0530",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.11.1.jar, environment: Java 17.0.1 (Eclipse Adoptium)"
)
@Component
public class FoodItemMapperImpl implements FoodItemMapper {

    @Override
    public FoodItem mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO) {
        if ( foodItemDTO == null ) {
            return null;
        }

        FoodItem foodItem = new FoodItem();

        foodItem.setId( foodItemDTO.getId() );
        foodItem.setItemName( foodItemDTO.getItemName() );
        foodItem.setItemDescription( foodItemDTO.getItemDescription() );
        foodItem.setVeg( foodItemDTO.isVeg() );
        foodItem.setPrice( foodItemDTO.getPrice() );
        foodItem.setRestaurantId( foodItemDTO.getRestaurantId() );
        foodItem.setQuantity( foodItemDTO.getQuantity() );

        return foodItem;
    }

    @Override
    public FoodItemDTO mapFoodItemToFoodItemDTO(FoodItem foodItem) {
        if ( foodItem == null ) {
            return null;
        }

        FoodItemDTO foodItemDTO = new FoodItemDTO();

        foodItemDTO.setId( foodItem.getId() );
        foodItemDTO.setItemName( foodItem.getItemName() );
        foodItemDTO.setItemDescription( foodItem.getItemDescription() );
        foodItemDTO.setVeg( foodItem.isVeg() );
        foodItemDTO.setPrice( foodItem.getPrice() );
        foodItemDTO.setRestaurantId( foodItem.getRestaurantId() );
        foodItemDTO.setQuantity( foodItem.getQuantity() );

        return foodItemDTO;
    }

    @Override
    public List<FoodItemDTO> mapFoodItemListToFoodItemDTOList(List<FoodItem> list) {
        if ( list == null ) {
            return null;
        }

        List<FoodItemDTO> list1 = new ArrayList<FoodItemDTO>( list.size() );
        for ( FoodItem foodItem : list ) {
            list1.add( mapFoodItemToFoodItemDTO( foodItem ) );
        }

        return list1;
    }
}
