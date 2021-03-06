package com.example.clientmobile.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse <T> {
    @Builder.Default
    private boolean success = true;
    private String message;
    private T obj;
}
