package com.example.couriermobile.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApiResponse<T> {
    private String message;
    @Builder.Default
    private boolean success=false;
    private T data;
}
