package com.example.clientservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AttachmentDto {
    private String name, type, url;
    private Long size;
}
