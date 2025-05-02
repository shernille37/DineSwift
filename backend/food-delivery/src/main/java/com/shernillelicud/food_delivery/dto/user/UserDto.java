package com.shernillelicud.food_delivery.dto.user;

import com.shernillelicud.food_delivery.dto.address.AddressDto;
import com.shernillelicud.food_delivery.dto.restaurant.RestaurantDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String firstname;

    private String lastname;

    private String email;

    private String role;

    private List<RestaurantDto> favorites;

    private List<AddressDto> addresses;

}
