package com.shernillelicud.food_delivery.request.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class NewCategoryRequest {

    private Long userId;

    private String name;

}
