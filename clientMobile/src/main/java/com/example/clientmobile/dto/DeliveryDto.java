package com.example.clientmobile.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class DeliveryDto {
    private BigDecimal price;
    private  Float longitude;
    private  Float latitude;
    private  HumanDto courier;
    private  String address;
}
