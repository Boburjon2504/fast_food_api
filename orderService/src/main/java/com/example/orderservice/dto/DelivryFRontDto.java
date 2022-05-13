package com.example.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class DelivryFRontDto {
    private final BigDecimal price;
    private final Float longitude;
    private final Float latitude;
    private final String address;
    private final HumanFrontDto courier;
}
