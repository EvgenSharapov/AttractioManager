package com.example.aston.model;

import jakarta.persistence.*;


import java.util.Set;
import java.util.UUID;


@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;

    @ManyToMany(mappedBy = "services")
    private Set<Attraction> attractions;
}