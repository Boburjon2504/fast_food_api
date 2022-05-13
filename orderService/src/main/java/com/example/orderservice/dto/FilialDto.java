package com.example.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalTime;

@AllArgsConstructor
@Getter
public class FilialDto {
    private final String nameUz;
    private final String nameRu;
    private final String intended;
    private final String address;
    private final LocalTime start;
    private final LocalTime finish;
    private final Float latitude;
    private final Float longitude;
}
