package com.example.clientmobile.controller;

import com.example.clientmobile.dto.ApiResponse;
import com.example.clientmobile.dto.HumanDto;
import com.example.clientmobile.entity.Attachment;
import com.example.clientmobile.entity.Human;
import com.example.clientmobile.repository.HumanRepository;
import com.example.clientmobile.service.HumanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/client")
@RequiredArgsConstructor
@RestController
public class ClientContrller {

    final HumanService humanService;
    final HumanRepository humanRepository;

    @PostMapping
    public HttpEntity<?> add(@RequestBody HumanDto humanDto){
        ApiResponse<Human> add = humanService.add(humanDto);
        return ResponseEntity.ok().body("added");
    }
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Long id, @RequestBody HumanDto humanDto){
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

    @PostMapping("/{id}/block")
    public HttpEntity<?> block(@PathVariable Long id){
        ApiResponse<Human> block = humanService.block(id);
        return ResponseEntity.ok().body("blocked");
    }
    @GetMapping("/{id}/photo")
    public HttpEntity<?> getPhoto(@PathVariable Long id){
        Optional<Human> byId = humanRepository.findById(id);
        if (byId.isEmpty()){
            return ResponseEntity.ok().body("not found");
        }
        Attachment photo = byId.get().getPhoto();
        return ResponseEntity.ok().contentType(MediaType.valueOf(photo.getType()))
                .contentLength(photo.getSize())
                .body(photo.getBytes());
    }

}
