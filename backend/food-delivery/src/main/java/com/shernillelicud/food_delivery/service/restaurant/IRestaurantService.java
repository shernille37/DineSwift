package com.shernillelicud.food_delivery.service.restaurant;

import com.shernillelicud.food_delivery.dto.restaurant.RestaurantDto;
import com.shernillelicud.food_delivery.model.Restaurant;
import com.shernillelicud.food_delivery.model.User;
import com.shernillelicud.food_delivery.request.restaurant.NewRestaurantRequest;

import java.util.List;

public interface IRestaurantService {

    public List<Restaurant> getAllRestaurant();

    public Restaurant getRestaurantById(Long id);

    public List<Restaurant> searchRestaurant(String keyword);

    public Restaurant addRestaurant(NewRestaurantRequest request, User owner);

    public Restaurant updateRestaurant(Long id, NewRestaurantRequest request);

    public Restaurant addToFavorites(Long id, User user);

    public void deleteRestaurant(Long id);

    public Restaurant updateRestaurantStatus(Long id);

    public RestaurantDto convertToDto(Restaurant restaurant);
}
