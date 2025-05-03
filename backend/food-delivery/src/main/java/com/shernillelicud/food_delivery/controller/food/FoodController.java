package com.shernillelicud.food_delivery.controller.food;

import com.shernillelicud.food_delivery.dto.food.FoodDto;
import com.shernillelicud.food_delivery.dto.restaurant.RestaurantDto;
import com.shernillelicud.food_delivery.model.Food;
import com.shernillelicud.food_delivery.model.Restaurant;
import com.shernillelicud.food_delivery.request.food.NewFoodRequest;
import com.shernillelicud.food_delivery.response.ApiResponse;
import com.shernillelicud.food_delivery.service.food.IFoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/foods")
public class FoodController {

    private final IFoodService foodService;

    @PostMapping
    ResponseEntity<ApiResponse> addFood(@RequestBody NewFoodRequest request) {
            Food newFood = foodService.addFood(request);
            FoodDto foodDto = foodService.convertToDto(newFood);

            ApiResponse apiResponse = ApiResponse.builder()
                    .message("Food added successfully")
                    .data(foodDto)
                    .build();

            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllFoodRestaurant(
            @RequestParam String restaurantId,
            @RequestParam String isVegetarian,
            @RequestParam String isSeasonal,
            @RequestParam String category
    ) {

        List<Food> foodList = foodService.getAllFoodRestaurant(
                Long.valueOf(restaurantId),
                Boolean.valueOf(isVegetarian),
                Boolean.valueOf(isSeasonal),
                category
                );

        List<FoodDto> foodDtoList = foodList
                .stream()
                .map(foodService::convertToDto)
                .toList();

        ApiResponse apiResponse = ApiResponse.builder()
                .message("Success")
                .data(foodDtoList)
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/search")
    ResponseEntity<ApiResponse> searchFood(
            @RequestParam String keyword
    ) {

        List<Food> foodList = foodService.searchFood(keyword);
        List<FoodDto> foodDtoList = foodList.stream()
                .map(foodService::convertToDto)
                .toList();

        ApiResponse apiResponse = ApiResponse.builder()
                .message("Success")
                .data(foodDtoList)
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    ResponseEntity<ApiResponse> updateAvailability(
            @PathVariable String id
    ) {

        Food food = foodService.updateAvailabilityStatus(Long.valueOf(id));
        FoodDto foodDto = foodService.convertToDto(food);

        ApiResponse apiResponse = ApiResponse.builder()
                .message("Success")
                .data(foodDto)
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    ResponseEntity<ApiResponse> deleteFood(
            @PathVariable String id
    ) {

        foodService.deleteFood(Long.valueOf(id));


        ApiResponse apiResponse = ApiResponse.builder()
                .message("Success")
                .data(null)
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.NO_CONTENT);

    }

}
