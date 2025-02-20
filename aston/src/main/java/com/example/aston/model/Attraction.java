package com.example.aston.model;

import jakarta.persistence.*;


import java.util.Set;
import java.util.UUID;


@Entity
public class Attraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

//    @Enumerated(EnumType.STRING)
//    private AttractionType attractionType;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public AttractionType getAttractionType() {
//        return attractionType;
//    }

//    public void setAttractionType(AttractionType attractionType) {
//        this.attractionType = attractionType;
//    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }

    public TicketInfo getTicketInfo() {
        return ticketInfo;
    }

    public void setTicketInfo(TicketInfo ticketInfo) {
        this.ticketInfo = ticketInfo;
    }
}