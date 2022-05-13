package com.example.orderservice.service;

import com.example.orderservice.dto.ApiResponse;
import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.dto.OrderFrontDto;
import com.example.orderservice.entity.Order;
import com.example.orderservice.entity.OrderProduct;
import com.example.orderservice.entity.Product;
import com.example.orderservice.mapper.OrderMapper;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    final OrderMapper orderMapper;
    final OrderRepository repository;
    final ProductRepository productRepository;
    public ApiResponse<Order> add(OrderDto orderDto){
        Order order = orderMapper.toEntity(orderDto);
        double all = 0;
        for (OrderProduct orderProduct : order.getProducts()) {
            Optional<Product> optionalProduct = productRepository.findById(orderProduct.getProduct().getId());
            if (optionalProduct.isEmpty()) {
                continue;
            }
            orderProduct.setProduct(optionalProduct.get());
            BigDecimal price = optionalProduct.get().getPrice().multiply(BigDecimal.valueOf(orderProduct.getCount()));
//            orderProduct.setCount(price);
            orderProduct.setPrice(optionalProduct.get().getPrice());
            all += price.doubleValue();
        }
        order.setAmount(BigDecimal.valueOf(all));
        repository.save(order);

        return ApiResponse.<Order>builder().message("added").success(true).build();
    }
    public ApiResponse<Order> edit(Long id,OrderDto orderDto){
        Order order = orderMapper.toEntity(orderDto);
        order.setId(id);
        repository.save(order);
        return ApiResponse.<Order>builder().success(true).message("edited").build();
    }
    public ApiResponse<Order> delete(Long id){
        Optional<Order> byId = repository.findById(id);
        if (byId.isEmpty()){
            return ApiResponse.<Order>builder().message("not found").success(false).build();
        }
        repository.existsById(id);
        return ApiResponse.<Order>builder().success(true).message("deleted").build();
    }
}
