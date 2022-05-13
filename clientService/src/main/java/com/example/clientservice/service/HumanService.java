package com.example.clientservice.service;

import com.example.clientservice.dto.ApiResponse;
import com.example.clientservice.dto.HumanDto;
import com.example.clientservice.entity.Human;
import com.example.clientservice.mapper.HumanMapper;
import com.example.clientservice.repository.HumanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class HumanService {
    final HumanMapper humanMapper;
    final HumanRepository humanRepository;
    public ApiResponse<Human> add(HumanDto humanDto){
        Human human = humanMapper.toEntity(humanDto);
        humanRepository.save(human);
        return ApiResponse.<Human>builder().success(true).message("added").build();
    }

    public ApiResponse<Human> edit (Long id, HumanDto humanDto){
        Human human = humanMapper.toEntity(humanDto);
        human.setId(id);
        humanRepository.save(human);
        return ApiResponse.<Human>builder().success(true).message("added").build();
    }
    public ApiResponse<Human> delete(Long id){
        Optional<Human> byId = humanRepository.findById(id);
        if (byId.isEmpty()){
            return ApiResponse.<Human>builder().success(false).message(byId.get().getId()+"not found").build();
        }
        humanRepository.deleteById(id);
        return ApiResponse.<Human>builder().success(true).message("deletede").build();
    }

}
