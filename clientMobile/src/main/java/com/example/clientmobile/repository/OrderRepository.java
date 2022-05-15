package com.example.clientmobile.repository;

import com.example.clientmobile.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Long> {
    Optional<Order> findByClient_Id(Long clientId);
}
