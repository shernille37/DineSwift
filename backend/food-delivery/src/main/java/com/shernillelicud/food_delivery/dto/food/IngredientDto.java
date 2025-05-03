package com.shernillelicud.food_delivery.dto.food;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDto {

    private Long id;

    private String name;

    private Boolean isInStock;

}
