package com.example.aston.dto;

import com.example.aston.model.ServiceType;
import lombok.Builder;

@Builder
public record AttractionServiceRequestDTO (
        String name,
        String description,
        ServiceType type
){
}