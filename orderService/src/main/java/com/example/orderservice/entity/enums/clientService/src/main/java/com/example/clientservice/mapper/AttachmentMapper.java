package com.example.clientservice.mapper;

import com.example.clientservice.entity.Attachment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Mapper(componentModel = "spring")
public interface AttachmentMapper {
    @Mapping(source = "originalFilename",target = "name")
    void update(MultipartFile file, @MappingTarget Attachment attachment)throws IOException;
}
