package com.shernillelicud.food_delivery.dto.restaurant;

import com.shernillelicud.food_delivery.dto.address.AddressDto;
import com.shernillelicud.food_delivery.dto.user.OwnerRestaurantDto;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Embeddable
public class RestaurantDto {

    private Long id;

    private String name;

    private OwnerRestaurantDto owner;

    private AddressDto address;

    @Column(length = 1000)
    private List<String> images = new ArrayList<>();

    private String description;

    private String cuisineType;

    private Boolean isOpen;


}
