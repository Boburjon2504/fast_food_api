package com.example.clientservice.mapper;

import com.example.clientservice.dto.HumanDto;
import com.example.clientservice.entity.Attachment;
import com.example.clientservice.entity.Human;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Mapper(componentModel = "spring")
public interface HumanMapper {
    @Mapping(source = "contentType",target = "type")
    @Mapping(source = "originalFilename",target = "name")
    Attachment a(MultipartFile file) throws IOException;
    @Mapping(source = "userType", target = "userType")
    Human toEntity(HumanDto humanDto);

}
