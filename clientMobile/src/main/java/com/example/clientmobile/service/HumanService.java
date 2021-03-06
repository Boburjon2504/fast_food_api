package com.example.clientmobile.service;

import com.example.clientmobile.dto.ApiResponse;
import com.example.clientmobile.dto.HumanDto;
import com.example.clientmobile.entity.Human;
import com.example.clientmobile.entity.enums.ClientStatus;
import com.example.clientmobile.mapper.HumanMapper;
import com.example.clientmobile.repository.HumanRepository;
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
    public ApiResponse<Human> block(Long id){
        Optional<Human> byId = humanRepository.findById(id);
        byId.get().setStatus(ClientStatus.BLOCK);
        humanRepository.save(byId.get());
        return ApiResponse.<Human>builder().message("blocked").success(true).build();
    }




}
