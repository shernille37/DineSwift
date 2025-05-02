package com.shernillelicud.food_delivery.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OwnerRestaurantDto {

    private String firstname;

    private String lastname;

    private String email;

}
