package com.example.aston.dto;

import lombok.Builder;

@Builder
public record AttractionServiceRequestDTO (
        String name,
        String description
){
}