package com.shernillelicud.food_delivery.service.restaurant;

import com.shernillelicud.food_delivery.dto.restaurant.RestaurantDto;
import com.shernillelicud.food_delivery.exception.RestaurantNotFoundException;
import com.shernillelicud.food_delivery.model.Restaurant;
import com.shernillelicud.food_delivery.model.User;
import com.shernillelicud.food_delivery.repository.user.UserRepository;
import com.shernillelicud.food_delivery.repository.restaurant.AddressRepository;
import com.shernillelicud.food_delivery.repository.restaurant.RestaurantContactRepository;
import com.shernillelicud.food_delivery.repository.restaurant.RestaurantRepository;
import com.shernillelicud.food_delivery.request.restaurant.NewRestaurantRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService implements IRestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final AddressRepository addressRepository;
    private final RestaurantContactRepository restaurantContactRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(RestaurantNotFoundException::new);
    }

    @Override
    public List<Restaurant> searchRestaurant(String keyword) {
        return restaurantRepository.findBySearchQuery(keyword);
    }

    @Override
    public Restaurant addRestaurant(NewRestaurantRequest request, User owner) {

        addressRepository.save(request.getAddress());
        restaurantContactRepository.save(request.getRestaurantContact());

        Restaurant newRestaurant = modelMapper.map(request, Restaurant.class);

        newRestaurant.setOwner(owner);

        return restaurantRepository.save(newRestaurant);
    }




    @Override
    public Restaurant updateRestaurant(Long id, NewRestaurantRequest request) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(RestaurantNotFoundException::new);

        modelMapper.map(request, restaurant);

        return restaurant;
    }

    @Override
    public Restaurant addToFavorites(Long id, User user) {

        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(RestaurantNotFoundException::new);

        if(user.getFavorites().contains(restaurant))
            user.getFavorites().remove(restaurant);
        else
            user.getFavorites().add(restaurant);

        userRepository.save(user);

        return restaurant;

    }

    @Override
    public void deleteRestaurant(Long id) {

        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(RestaurantNotFoundException::new);

        restaurantRepository.delete(restaurant);

    }

    @Override
    public Restaurant updateRestaurantStatus(Long id) {

        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(RestaurantNotFoundException::new);

        restaurant.setIsOpen(!restaurant.getIsOpen());

        return restaurantRepository.save(restaurant);
    }

    @Override
    public RestaurantDto convertToDto(Restaurant restaurant) {
        RestaurantDto restaurantDto =  modelMapper.map(restaurant, RestaurantDto.class);

        restaurantDto.getOwner().setFullname(restaurant.getOwner().getFirstname() + " " + restaurant.getOwner().getLastname());

        return restaurantDto;
    }
}
