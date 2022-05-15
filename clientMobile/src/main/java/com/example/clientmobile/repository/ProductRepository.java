package com.example.clientmobile.repository;

import com.example.clientmobile.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
