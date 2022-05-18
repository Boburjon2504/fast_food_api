package com.example.couriermobile.controller;

import com.example.couriermobile.dto.ApiResponse;
import com.example.couriermobile.entity.Human;
import com.example.couriermobile.repository.HumanRepository;
import com.example.couriermobile.service.CurierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courier")
@RequiredArgsConstructor
public class CourierController {
final HumanRepository humanRepository;
final CurierService service;
    @GetMapping("/{id}/number")
    public HttpEntity<?> getNumber(@PathVariable Long id) {
        Optional<Human> byId = humanRepository.findById(id);
        return ResponseEntity.ok().body(byId.get().getNumber());
    }

    // didnt check
    @PutMapping("/{id}")
    public HttpEntity<?> editPhoto(@PathVariable Long id, @RequestBody MultipartFile file){
        ApiResponse<Human> humanApiResponse = service.changeFoto(id, file);
        return ResponseEntity.ok().body("changed");
    }
}
