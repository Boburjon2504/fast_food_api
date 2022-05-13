package com.example.clientservice.controller;

import com.example.clientservice.entity.Human;
import com.example.clientservice.entity.UserType;
import com.example.clientservice.repository.HumanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employe")
public class EmployeController {
    final HumanRepository humanRepository;

    @GetMapping("/admin")
    public HttpEntity<?> getAllAdmin(){
        List<Human> byUserType = humanRepository.findByUserType(UserType.ADMIN);
        return ResponseEntity.ok().body(byUserType);
    }
    @GetMapping("/client")
    public HttpEntity<?> getAllClient(){
        List<Human> byUserType = humanRepository.findByUserType(UserType.CLIENT);
        return ResponseEntity.ok().body(byUserType);
    }
    @GetMapping("/operator")
    public HttpEntity<?> getAlloperator(){
        List<Human> byUserType = humanRepository.findByUserType(UserType.OPERATOR);
        return ResponseEntity.ok().body(byUserType);
    }
    @GetMapping("/courier")
    public HttpEntity<?> getAllcourier(){
        List<Human> byUserType = humanRepository.findByUserType(UserType.COURIER);
        return ResponseEntity.ok().body(byUserType);
    }

}
