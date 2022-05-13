package com.example.adminservice.service;

import com.example.adminservice.dto.ApiResponse;
import com.example.adminservice.dto.CategoryDto;
import com.example.adminservice.entity.Category;
import com.example.adminservice.mapper.CategoryMapper;
import com.example.adminservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategorySrevice {
    final CategoryMapper categoryMapper;
    final CategoryRepository categoryRepository;

    public ApiResponse<Category> add(CategoryDto categoryDto){
        Category category = categoryMapper.toEntity(categoryDto);
        Category save = categoryRepository.save(category);
        return ApiResponse.<Category>builder().message("added").success(true).build();
    }
    public ApiResponse<Category> edit (Long id, CategoryDto categoryDto){
        Category category = categoryMapper.toEntity(categoryDto);
        category.setId(id);
        Category save = categoryRepository.save(category);
        return ApiResponse.<Category>builder().message("changed").success(true).build();
    }
    public ApiResponse<Category> delete(Long id){
        Optional<Category> byId = categoryRepository.findById(id);
        if (byId.isEmpty()){
            return ApiResponse.<Category>builder().message("not found").success(false).build();
        }
        categoryRepository.existsById(id);
        return ApiResponse.<Category>builder().message("deleted").success(true).build();
    }
}
