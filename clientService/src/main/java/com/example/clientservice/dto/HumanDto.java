package com.example.clientservice.dto;

import com.example.clientservice.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HumanDto {
    private String name;
//    private String password;
    private String number;
    private ClientStatus status;
    private LocalDate birthdate;
    private Region region;
    private Language lang;
    private UserType userType;
    private Attachment photo;


}
