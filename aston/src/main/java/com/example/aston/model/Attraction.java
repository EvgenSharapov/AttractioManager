package com.example.aston.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Set;
import java.util.UUID;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Attraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attraction_id")
    private UUID id;
    private String name;
    private String description;

//    @OneToOne(mappedBy = "address_id")
//    @Column(name = "attraction_id")
//    private UUID addressId;

    @Enumerated(EnumType.STRING)
    private AttractionType attractionType;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany
    @JoinTable(
            name = "attraction_service",
            joinColumns = @JoinColumn(name = "attraction_id",referencedColumnName = "attraction_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id",referencedColumnName = "service_id"))
    private Set<AttractionService> services;

    @OneToOne(mappedBy = "attraction")
    private TicketInfo ticketInfo;


}