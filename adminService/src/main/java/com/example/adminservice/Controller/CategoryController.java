package com.example.adminservice.Controller;

import com.example.adminservice.dto.ApiResponse;
import com.example.adminservice.dto.CategoryDto;
import com.example.adminservice.entity.Category;
import com.example.adminservice.repository.CategoryRepository;
import com.example.adminservice.service.CategorySrevice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {
    final CategoryRepository categoryRepository;
    final CategorySrevice categorySrevice;

    @PostMapping
    public HttpEntity<?> add(@RequestBody CategoryDto categoryDto) {
        ApiResponse<Category> add = categorySrevice.add(categoryDto);
        return ResponseEntity.status(add.isSuccess()?200:400).body(add);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Long id, @RequestBody CategoryDto categoryDto){
        ApiResponse<Category> edit = categorySrevice.edit(id, categoryDto);
        return ResponseEntity.status(edit.isSuccess()?200:400).body(edit);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete (@PathVariable Long id){
        ApiResponse<Category> delete = categorySrevice.delete(id);
        return ResponseEntity.status(delete.isSuccess()?200:400).body(delete);
    }
    @GetMapping
    public HttpEntity<?> getAll(){
        List<Category> all = categoryRepository.findAll();
        return ResponseEntity.ok().body(all);
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Long id){
        Optional<Category> byId = categoryRepository.findById(id);
        return ResponseEntity.ok().body(byId.get());
    }
}
