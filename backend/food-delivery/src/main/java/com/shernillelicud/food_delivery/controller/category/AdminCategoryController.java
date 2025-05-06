package com.shernillelicud.food_delivery.controller.category;


import com.shernillelicud.food_delivery.model.Category;
import com.shernillelicud.food_delivery.request.category.NewCategoryRequest;
import com.shernillelicud.food_delivery.response.ApiResponse;
import com.shernillelicud.food_delivery.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/categories")
public class AdminCategoryController {

    private final CategoryService categoryService;


    @PostMapping
    public ResponseEntity<ApiResponse> addCategory(@RequestBody NewCategoryRequest request) {

        Category newCategory = categoryService.addCategory(request);

        return new ResponseEntity<>(new ApiResponse("Category created successfully", newCategory), HttpStatus.CREATED);

    }

}
