package com.example.aston.dto;

import lombok.Builder;

@Builder
public record AttractionRequestDTO (
        String name,
        String description
){
}