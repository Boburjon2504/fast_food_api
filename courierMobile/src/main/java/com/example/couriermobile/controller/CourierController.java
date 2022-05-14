package com.example.couriermobile.controller;

import com.example.couriermobile.entity.Human;
import com.example.couriermobile.repository.HumanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courier")
@RequiredArgsConstructor
public class CourierController {
final HumanRepository humanRepository;

    @GetMapping("/{id}/number")
    public HttpEntity<?> getNumber(@PathVariable Long id) {
        Optional<Human> byId = humanRepository.findById(id);
        return ResponseEntity.ok().body(byId.get().getNumber());
    }


}
