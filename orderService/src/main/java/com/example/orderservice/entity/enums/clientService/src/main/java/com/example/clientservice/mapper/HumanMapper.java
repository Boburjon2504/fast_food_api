package com.example.clientservice.mapper;

import com.example.clientservice.dto.HumanDto;
import com.example.clientservice.entity.Human;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {AttachmentMapper.class})
public interface HumanMapper {

//    @Mapping(source = "type", target = "userType")
//    @Mapping(source = "password", target = "password", qualifiedByName = "password")
    Human toEntity(HumanDto humanDto);

   }
