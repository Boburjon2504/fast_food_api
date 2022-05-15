package com.example.clientmobile.dto;

import com.example.clientmobile.entity.Attachment;
import com.example.clientmobile.entity.enums.ClientStatus;
import com.example.clientmobile.entity.enums.Language;
import com.example.clientmobile.entity.enums.Region;
import com.example.clientmobile.entity.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
