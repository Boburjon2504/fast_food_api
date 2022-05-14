package com.example.couriermobile.dto;

import com.example.couriermobile.entity.enums.OrderStatus;
import com.example.couriermobile.entity.enums.PayType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
