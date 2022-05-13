package com.example.orderservice.dto;

import com.example.orderservice.entity.enums.OrderStatus;
import com.example.orderservice.entity.enums.PayType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private List<OrderProductdto> products;
    private PayType payType;
    private Long filialId;
    private OrderStatus orderStatus;
    private Long clientId;
}
