package com.example.orderservice.mapper;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.dto.OrderProductdto;
import com.example.orderservice.entity.Order;
import com.example.orderservice.entity.OrderProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(source = "filialId",target = "filial.id")
    @Mapping(source = "clientId",target = "client.id")
    Order toEntity(OrderDto orderDto);

    @Mapping(source = "productId", target = "product.id")
    OrderProduct orderProductDtoToOrderProduct(OrderProductdto dto);

}
