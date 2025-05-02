package com.shernillelicud.food_delivery.request.restaurant;

import com.shernillelicud.food_delivery.model.Address;
import com.shernillelicud.food_delivery.model.RestaurantContact;
import lombok.Data;

import java.util.List;

@Data
public class NewRestaurantRequest {

    private String name;

    private String description;

    private String cuisineType;

    private Address address;

    private RestaurantContact restaurantContact;

    private String openingHours;

    private List<String> images;

}
