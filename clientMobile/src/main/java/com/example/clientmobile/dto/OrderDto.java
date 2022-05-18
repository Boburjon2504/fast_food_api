package com.example.clientmobile.dto;

import com.example.clientmobile.entity.enums.OrderStatus;
import com.example.clientmobile.entity.enums.PayType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {
    private  LocalDateTime time;
    private List<OrderProductDto> products;
    private  HumanDto operator;
    private  PayType payType;
    private  DeliveryDto delivery;
    private  FilialDto filial;
    private  OrderStatus orderStatus;
    private  HumanDto client;
}
