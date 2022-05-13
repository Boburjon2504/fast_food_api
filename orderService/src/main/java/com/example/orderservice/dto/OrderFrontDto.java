package com.example.orderservice.dto;

import com.example.orderservice.entity.enums.OrderStatus;
import com.example.orderservice.entity.enums.PayType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
public class OrderFrontDto {
    private final LocalDateTime time;
    private final List<OrderFrontDto> products;
    private final HumanFrontDto operator, client;
    private final PayType payType;
    private final DelivryFRontDto delivery;
    private final FilialDto filial;
    private final OrderStatus orderStatus;
    private final BigDecimal amount;
}
