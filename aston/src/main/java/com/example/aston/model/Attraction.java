package com.example.aston.model;

import jakarta.persistence.*;


import java.util.Set;
import java.util.UUID;


@Entity
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
    private Set<Service> services;

    @OneToOne(mappedBy = "attraction")
    private TicketInfo ticketInfo;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public AttractionType getAttractionType() {
        return attractionType;
    }

    public void setAttractionType(AttractionType attractionType) {
        this.attractionType = attractionType;
    }

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

//    public UUID getAddressId() {
//        return addressId;
//    }
//
//    public void setAddressId(UUID addressId) {
//        this.addressId = addressId;
//    }
}