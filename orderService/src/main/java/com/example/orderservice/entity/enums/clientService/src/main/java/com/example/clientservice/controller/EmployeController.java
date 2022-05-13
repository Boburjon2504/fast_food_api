package com.example.clientservice.controller;

import com.example.clientservice.entity.Human;
import com.example.clientservice.repository.HumanRepository;
import lombok.RequiredArgsConstructor;


import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.clientservice.entity.enums.UserType;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/amploye")
public class EmployeController {
    final HumanRepository repository;

    @GetMapping("/admin")
    public HttpEntity<?> getAllAdmin() {
        List<Human> byUserType = repository.findByUserType(UserType.ADMIN);
        if (byUserType.isEmpty()) {
            return ResponseEntity.ok("not found");
        }
        return ResponseEntity.ok().body(byUserType);
    }

    @GetMapping("/curier")
    public HttpEntity<?> getAllcurier() {
        List<Human> byUserType = repository.findByUserType(UserType.COURIER);
        if (byUserType.isEmpty()) {
            return ResponseEntity.ok("not found");
        }
        return ResponseEntity.ok().body(byUserType);
    }

    @GetMapping("/operator")
    public HttpEntity<?> getAllOperator() {
        List<Human> byUserType = repository.findByUserType(UserType.OPERATOR);
        if (byUserType.isEmpty()) {
            return ResponseEntity.ok("not found");
        }
        return ResponseEntity.ok().body(byUserType);
    }

    @GetMapping("/client")
    public HttpEntity<?> getAllClient() {
        List<Human> byUserType = repository.findByUserType(UserType.CLIENT);
        if (byUserType.isEmpty()) {
            return ResponseEntity.ok("not found");
        }
        return ResponseEntity.ok().body(byUserType);
    }

}
