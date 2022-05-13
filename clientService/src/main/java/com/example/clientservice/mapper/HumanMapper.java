package com.example.clientservice.mapper;

import com.example.clientservice.dto.HumanDto;
import com.example.clientservice.entity.Human;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface HumanMapper {

    @Mapping(source = "userType", target = "userType")

    Human toEntity(HumanDto humanDto);

}
