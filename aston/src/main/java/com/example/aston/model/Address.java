package com.example.aston.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;


@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private Integer building;
    private String street;
    private String city;
    private String region;
    private Double longitude;
    private Double latitude;

    @OneToMany(mappedBy = "address")
    private List<Attraction> attractions;
}