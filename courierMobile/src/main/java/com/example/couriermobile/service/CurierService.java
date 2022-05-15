package com.example.couriermobile.service;

import com.example.couriermobile.AttachmentMapper;
import com.example.couriermobile.dto.ApiResponse;
import com.example.couriermobile.entity.Attachment;
import com.example.couriermobile.entity.Human;
import com.example.couriermobile.entity.Order;
import com.example.couriermobile.entity.enums.UserType;
import com.example.couriermobile.repository.HumanRepository;
import com.example.couriermobile.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurierService {
    final HumanRepository humanRepository;
    final AttachmentMapper attachmentMapper;

    public ApiResponse<Human> changeFoto(Long id, MultipartFile file) {
        Optional<Human> byId = humanRepository.findById(id);
        if (byId.isEmpty() || byId.get().getUserType() != UserType.COURIER) {
            return ApiResponse.<Human>builder().message("not found ").success(false).build();
        }
        try {
            byId.get().setPhoto(attachmentMapper.toEntity(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        humanRepository.save(byId.get());
        return ApiResponse.<Human>builder().success(true).message("added").build();
    }
}
