package com.example.adminservice.mapper;

import com.example.adminservice.dto.ProductDTO;
import com.example.adminservice.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDTO(Product product);

    @Mapping(source = "categoryId",target = "category.id")
    Product toEntity(ProductDTO productDTO);

    List<ProductDTO> toDTOList(List<Product> productList);
}