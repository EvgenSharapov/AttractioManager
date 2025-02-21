package com.example.aston.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AttractionRequestDTOTest {

    @Test
    public void testAttractionRequestDTO() {

        AttractionRequestDTO attraction = AttractionRequestDTO.builder()
                .name("Attraction")
                .description("Description")
                .build();


        assertEquals("Attraction", attraction.name());
        assertEquals("Description", attraction.description());
    }
}
