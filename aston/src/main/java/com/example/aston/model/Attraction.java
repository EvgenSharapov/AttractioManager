package com.example.aston.model;

import jakarta.persistence.*;


import java.util.Set;
import java.util.UUID;


@Entity
public class Attraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private AttractionType attractionType;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany
    @JoinTable(
            name = "attraction_service",
            joinColumns = @JoinColumn(name = "attraction_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"))
    private Set<Service> services;

    @OneToOne(mappedBy = "attraction")
    private TicketInfo ticketInfo;
}