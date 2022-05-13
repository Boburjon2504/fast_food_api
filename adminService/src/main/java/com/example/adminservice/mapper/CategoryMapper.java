package com.example.adminservice.mapper;

import com.example.adminservice.dto.CategoryDto;
import com.example.adminservice.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(source = "parentId",target = "parent.id")
    Category toEntity(CategoryDto categoryDto);
}
