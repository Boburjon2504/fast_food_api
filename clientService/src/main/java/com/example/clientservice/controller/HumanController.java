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
@RequestMapping("/human")
public class HumanController {
    final HumanService humanService;
    final HumanRepository humanRepository;

    @PostMapping
    public HttpEntity<?> add(@RequestBody HumanDto humanDto){
        ApiResponse<Human> add = humanService.add(humanDto);
        return ResponseEntity.ok().body("added");
    }
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Long id,@RequestBody HumanDto humanDto){
        ApiResponse<Human> edit = humanService.edit(id, humanDto);
        return ResponseEntity.ok().body("edited");
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Long id){
        ApiResponse<Human> delete = humanService.delete(id);
        return ResponseEntity.ok().body("deleted");
    }
    @GetMapping
    public HttpEntity<?> getAll(){
        List<Human> all = humanRepository.findAll();
        return ResponseEntity.ok().body(all);
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Long id){
        Optional<Human> byId = humanRepository.findById(id);
        return ResponseEntity.ok().body(byId);
    }

}
