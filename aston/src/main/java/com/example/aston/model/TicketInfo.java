package com.example.aston.model;

import jakarta.persistence.*;


import java.math.BigDecimal;
import java.util.UUID;


@Entity
public class TicketInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private BigDecimal price;
    private String currency;
    private Boolean availability;

    @OneToOne
    @JoinColumn(name = "attraction_id")
    private Attraction attraction;
}