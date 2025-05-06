package com.shernillelicud.food_delivery.service.category;

import com.shernillelicud.food_delivery.model.Category;
import com.shernillelicud.food_delivery.repository.food.CategoryRepository;
import com.shernillelicud.food_delivery.request.category.NewCategoryRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService{

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public Category addCategory(NewCategoryRequest request) {

        Category newCategory = modelMapper.map(request, Category.class);

        return categoryRepository.save(newCategory);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
