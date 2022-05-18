package com.example.clientmobile.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class OrderProductDto {
    private  Long productId;
    private  Integer count;
    private  BigDecimal price;
}
