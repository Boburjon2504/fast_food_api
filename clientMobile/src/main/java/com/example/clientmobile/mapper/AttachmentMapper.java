package com.example.clientmobile.mapper;

import com.example.clientmobile.entity.Attachment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AttachmentMapper {
    @Mapping(source = "originalFilename", target = "name")
    @Mapping(source = "contentType", target = "type")
    Attachment toEntity(MultipartFile file) throws IOException;

}
