package com.shernillelicud.food_delivery.service.category;

import com.shernillelicud.food_delivery.model.Category;
import com.shernillelicud.food_delivery.request.category.NewCategoryRequest;

import java.util.List;

public interface ICategoryService {

    public Category addCategory(NewCategoryRequest request);

    public List<Category> getAllCategories();

}
