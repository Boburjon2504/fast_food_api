package com.example.clientmobile.mapper;

import com.example.clientmobile.dto.ProductDTO;
import com.example.clientmobile.dto.ProductFDto;
import com.example.clientmobile.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductFDto toFrontDto(Product product);
    List<ProductFDto> toFrontDto(List<Product> products);

}
