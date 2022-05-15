package com.example.clientmobile.mapper;


import com.example.clientmobile.dto.HumanDto;
import com.example.clientmobile.entity.Human;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HumanMapper {

    @Mapping(source = "userType", target = "userType")
    Human toEntity(HumanDto humanDto);

}
