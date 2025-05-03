package com.shernillelicud.food_delivery.controller.restaurant;


import com.shernillelicud.food_delivery.dto.restaurant.RestaurantDto;
import com.shernillelicud.food_delivery.model.Restaurant;
import com.shernillelicud.food_delivery.model.User;
import com.shernillelicud.food_delivery.request.restaurant.NewRestaurantRequest;
import com.shernillelicud.food_delivery.response.ApiResponse;
import com.shernillelicud.food_delivery.service.restaurant.IRestaurantService;
import com.shernillelicud.food_delivery.service.user.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final IUserService userService;
    private final IRestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<ApiResponse> getAllRestaurants() {

        List<Restaurant> restaurantList = restaurantService.getAllRestaurant();
        List<RestaurantDto> restaurants = restaurantList.stream()
                .map(restaurantService::convertToDto)
                .toList();

        ApiResponse apiResponse = ApiResponse.builder()
                .message("Success")
                .data(restaurants)
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getRestaurantById(@PathVariable String id) {

        Restaurant restaurant = restaurantService.getRestaurantById(Long.valueOf(id));
        RestaurantDto restaurantDto = restaurantService.convertToDto(restaurant);

        ApiResponse apiResponse = ApiResponse.builder()
                .message("Success")
                .data(restaurantDto)
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);

    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse> searchRestaurant(
            @RequestParam String keyword
            ) {

        List<Restaurant> restaurants = restaurantService.searchRestaurant(keyword);
        List<RestaurantDto> restaurantDto = restaurants.stream()
                .map(restaurantService::convertToDto)
                .toList();

        ApiResponse apiResponse = ApiResponse.builder()
                .message("Success")
                .data(restaurantDto)
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<ApiResponse> addRestaurant(@RequestBody NewRestaurantRequest request, @RequestHeader("Authorization") String bearerToken) {

        User owner = userService.findUserByJwtToken(bearerToken);

        Restaurant newRestaurant = restaurantService.addRestaurant(request, owner);
        RestaurantDto restaurantDto = restaurantService.convertToDto(newRestaurant);

        ApiResponse apiResponse = ApiResponse.builder()
                .message("Restaurant created successfully")
                .data(restaurantDto)
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteRestaurant(@PathVariable String id) {
        restaurantService.deleteRestaurant(Long.valueOf(id));

        return new ResponseEntity<>(new ApiResponse("Restaurant deleted successfully", null), HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateRestaurant(@PathVariable String id, @RequestBody NewRestaurantRequest request) {

        Restaurant updatedRestaurant = restaurantService.updateRestaurant(Long.valueOf(id), request);
        RestaurantDto restaurantDto = restaurantService.convertToDto(updatedRestaurant);

        ApiResponse apiResponse = ApiResponse.builder()
                .message("Restaurant updated successfully")
                .data(restaurantDto)
                .build();

        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<ApiResponse> updateRestaurantStatus(@PathVariable String id) {

        Restaurant updatedRestaurant = restaurantService.updateRestaurantStatus(Long.valueOf(id));
        RestaurantDto restaurantDto = restaurantService.convertToDto(updatedRestaurant);

        ApiResponse apiResponse = ApiResponse.builder()
                .message("Restaurant status updated successfully")
                .data(restaurantDto)
                .build();

        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }


    @PutMapping("/{id}/favorites")
    public ResponseEntity<ApiResponse> addToFavorites(@RequestHeader("Authorization") String bearerToken, @PathVariable String id) {

        User user = userService.findUserByJwtToken(bearerToken);

        Restaurant favoriteRestaurant = restaurantService.addToFavorites(Long.valueOf(id), user);
        RestaurantDto restaurantDto = restaurantService.convertToDto(favoriteRestaurant);

        ApiResponse apiResponse = ApiResponse.builder()
                .message("Restaurant added to favorites")
                .data(restaurantDto)
                .build();

        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }



}
