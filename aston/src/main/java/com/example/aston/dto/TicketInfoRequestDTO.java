package com.example.aston.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record TicketInfoRequestDTO (
        BigDecimal price,
        String currency,
        Boolean availability
){
}