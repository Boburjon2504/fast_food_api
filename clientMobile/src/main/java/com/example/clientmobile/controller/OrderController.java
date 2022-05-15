package com.example.clientmobile.controller;

import com.example.clientmobile.entity.Order;
import com.example.clientmobile.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/order")
@RestController
public class OrderController {

    final OrderRepository orderRepository;

    @GetMapping("/{id}/client")
    public HttpEntity<?> getClient(@PathVariable Long id) {
        Optional<Order> byClient_id = orderRepository.findByClient_Id(id);
        if (byClient_id.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(byClient_id.get());
    }

}
