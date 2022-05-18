package com.example.clientmobile.controller;

import com.example.clientmobile.entity.Human;
import com.example.clientmobile.entity.Order;
import com.example.clientmobile.mapper.OrderMapper;
import com.example.clientmobile.repository.HumanRepository;
import com.example.clientmobile.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/order")
@RestController
public class OrderController {
    final OrderMapper orderMapper;
    final OrderRepository orderRepository;
    final HumanRepository humanRepository;

    @GetMapping("/{id}/client")
    public HttpEntity<?> getClient(@PathVariable Long id) {
        Optional<Order> byId = orderRepository.findById(id);
        if (byId.isEmpty()){
            return ResponseEntity.ok("empty");
        }
        return ResponseEntity.ok().body(byId.get().getClient());
    }
}

