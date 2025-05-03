package com.shernillelicud.food_delivery.controller.food;

import com.shernillelicud.food_delivery.dto.food.FoodDto;
import com.shernillelicud.food_delivery.model.Food;
import com.shernillelicud.food_delivery.request.food.NewFoodRequest;
import com.shernillelicud.food_delivery.response.ApiResponse;
import com.shernillelicud.food_delivery.service.food.IFoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
