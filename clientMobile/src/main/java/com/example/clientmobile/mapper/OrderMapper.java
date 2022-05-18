package com.example.clientmobile.mapper;

import com.example.clientmobile.dto.OrderDto;
import com.example.clientmobile.entity.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto orderToOrderDto(Order order);
    List<OrderDto> orderToOrderDto(List<Order> order);
}
