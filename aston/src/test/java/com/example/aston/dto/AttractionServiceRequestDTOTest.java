package com.example.aston.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AttractionServiceRequestDTOTest {

    @Test
    public void testAttractionServiceRequestDTO() {

        AttractionServiceRequestDTO service = AttractionServiceRequestDTO.builder()
                .name("Service")
                .description("Description")
                .build();


        assertEquals("Service", service.name());
        assertEquals("Description", service.description());
    }
}
