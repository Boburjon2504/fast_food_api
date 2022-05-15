package com.example.clientmobile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
    private Long categoryId;
    private MultipartFile photo;
    private String nameUz;
    private String nameRu;
    private BigDecimal price;
    private String description;
}
