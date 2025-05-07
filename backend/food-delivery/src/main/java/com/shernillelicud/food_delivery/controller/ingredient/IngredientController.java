package com.shernillelicud.food_delivery.controller.ingredient;


import com.shernillelicud.food_delivery.model.Category;
import com.shernillelicud.food_delivery.model.Ingredient;
import com.shernillelicud.food_delivery.request.ingredient.NewIngredientRequest;
import com.shernillelicud.food_delivery.response.ApiResponse;
import com.shernillelicud.food_delivery.service.category.CategoryService;
import com.shernillelicud.food_delivery.service.ingredient.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    @PostMapping
    public ResponseEntity<ApiResponse> addIngredient(@RequestBody NewIngredientRequest request) {
        Ingredient ingredient = ingredientService.createIngredient(request);

        return new ResponseEntity<>(new ApiResponse("Success", ingredient), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllIngredients() {
        List<Ingredient> ingredients = ingredientService.getAllIngredients();

        return new ResponseEntity<>(new ApiResponse("Success", ingredients), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateStock(@PathVariable String id) {
        Ingredient ingredient = ingredientService.updateStock(Long.valueOf(id));

        return new ResponseEntity<>(new ApiResponse("Success", ingredient), HttpStatus.OK);
    }

}
