package com.example.clientservice.service;

import com.example.clientservice.dto.ApiResponse;
import com.example.clientservice.dto.HumanDto;
import com.example.clientservice.entity.Human;
import com.example.clientservice.mapper.HumanMapper;
import com.example.clientservice.repository.HumanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HumanService {
    final HumanMapper humanMapper;
    final HumanRepository humanRepository;
    public ApiResponse<Human> add(HumanDto humanDto){
        Human human = humanMapper.toEntity(humanDto);
        Human save = humanRepository.save(human);
        return ApiResponse.<Human>builder().message("added").success(true).build();
    }
    public ApiResponse<Human> edit(Long id,HumanDto humanDto){
        Optional<Human> byId = humanRepository.findById(id);
        Human human=byId.get();
        humanMapper.toEntity(humanDto);
        human.setId(human.getId());
        Human save = humanRepository.save(human);
        return ApiResponse.<Human>builder().success(true).message("edited").build();
    }
    public ApiResponse<Object> delete(Long id){
        humanRepository.existsById(id);
        return ApiResponse.builder().message("deleted").success(true).build();
    }
}
