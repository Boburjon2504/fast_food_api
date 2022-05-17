package com.example.clientmobile.controller;

import com.example.clientmobile.entity.Category;
import com.example.clientmobile.entity.Product;
import com.example.clientmobile.repository.CategoryRepository;
import com.example.clientmobile.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    final ProductRepository repository;
    final CategoryRepository categoryRepository;
    @GetMapping("/{id}")
    public HttpEntity<?> getProduct(@PathVariable Long id){
        Optional<Product> byId = repository.findById(id);
        return ResponseEntity.ok().body(byId);
    }

    @GetMapping
    public HttpEntity<?> getProductByCategory(@PathVariable Long categoryId){
        Optional<Category> byId = categoryRepository.findById(categoryId);
       List<Product> allProducts = repository.findAll(Example.of(Product.builder().category(byId.get()).build()));
       return ResponseEntity.ok().body(allProducts);
    }
}
