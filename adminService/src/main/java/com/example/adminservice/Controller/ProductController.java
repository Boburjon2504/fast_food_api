package com.example.adminservice.Controller;


import com.example.adminservice.dto.ApiResponse;
import com.example.adminservice.dto.ProductDTO;
import com.example.adminservice.entity.Product;
import com.example.adminservice.mapper.ProductMapper;
import com.example.adminservice.repository.ProductRepositary;
import com.example.adminservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    final ProductRepositary productRepository;
    final ProductService productService;
    final ProductMapper productMapper;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ProductDTO productDTO) {
        ApiResponse add = productService.add(productDTO);
        return ResponseEntity.ok().body(add);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        Optional<Product> byId = productRepository.findById(id);
        return ResponseEntity.ok().body(byId.get());
    }

    @GetMapping
    public ResponseEntity getALL() {
        List<Product> all = productRepository.findAll();
        return ResponseEntity.ok(all);
    }
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        Optional<Product> user = productRepository.findById(id);
        if (user.isEmpty()) {
            return ResponseEntity.ok().body("product not Found");
        }
        productRepository.delete(user.get());
        return ResponseEntity.ok().body("Deleted");
    }
    @PutMapping("/{id}")
    public ResponseEntity edit(@PathVariable Long id, @RequestBody ProductDTO dto) {
        ApiResponse response = productService.edit(id, dto);
        return ResponseEntity.status(response.isSuccess() ? 200 : 409).body(response);
    }

}

