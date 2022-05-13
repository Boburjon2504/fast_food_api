package com.example.clientservice.dto;

import com.example.clientservice.entity.enums.ClientStatus;
import com.example.clientservice.entity.enums.Language;
import com.example.clientservice.entity.enums.Region;
import com.example.clientservice.entity.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HumanDto {

    private String name;

    private String number;

    private ClientStatus status;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthdate;

    private Region region;

    private Language lang;

    private UserType userType;

    private MultipartFile photo;

}
