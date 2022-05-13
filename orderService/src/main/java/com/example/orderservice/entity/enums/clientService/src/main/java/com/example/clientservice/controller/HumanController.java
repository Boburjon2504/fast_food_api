package com.example.clientservice.controller;

import com.example.clientservice.dto.ApiResponse;
import com.example.clientservice.dto.HumanDto;
import com.example.clientservice.entity.Human;
import com.example.clientservice.repository.HumanRepository;
import com.example.clientservice.service.HumanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/human")
public class HumanController {
    final HumanService service;
    final HumanRepository repository;

    @PostMapping
    public HttpEntity<?> add(@RequestBody HumanDto humanDto){
        ApiResponse<Human> add = service.add(humanDto);
        return ResponseEntity.status(add.isSuccess()?200:400).body(add);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Long id,@RequestBody HumanDto humanDto){
        ApiResponse<Human> edit = service.edit(id, humanDto);
        return ResponseEntity.status(edit.isSuccess()?200:400).body(edit);
    }
    @DeleteMapping("/{id}")
public HttpEntity<?> delete (@PathVariable Long id){
        ApiResponse<Object> delete = service.delete(id);
        return ResponseEntity.status(delete.isSuccess()?200:400).body(delete);
    }
    @GetMapping
    public HttpEntity<?> getAll(){
        List<Human> all = repository.findAll();
        return ResponseEntity.ok().body(all);

    }
    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Long id){
        Optional<Human> byId = repository.findById(id);
        return ResponseEntity.ok().body(byId);
    }
}
