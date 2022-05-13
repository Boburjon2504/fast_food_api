package com.example.orderservice.controller;

import com.example.orderservice.dto.ApiResponse;
import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.entity.Order;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {
    final OrderService orderService;
    final OrderRepository orderRepository;

    @PostMapping
    public HttpEntity<?> add(@RequestBody OrderDto orderDto){
        ApiResponse<Order> add = orderService.add(orderDto);
        return ResponseEntity.status(add.isSuccess()?200:400).body(add);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Long id,@RequestBody OrderDto orderDto){
        ApiResponse<Order> edit = orderService.edit(id, orderDto);
        return ResponseEntity.status(edit.isSuccess()?200:400).body(edit);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete (@PathVariable Long id){
        ApiResponse<Order> delete = orderService.delete(id);
        return ResponseEntity.status(delete.isSuccess()?200:400).body(delete);
    }
    @GetMapping
    public HttpEntity<?> getAll(){
        List<Order> all = orderRepository.findAll();
        return ResponseEntity.ok().body(all);
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getOne (@PathVariable Long id){
        Optional<Order> byId = orderRepository.findById(id);
        return ResponseEntity.ok().body(byId);
    }
}

