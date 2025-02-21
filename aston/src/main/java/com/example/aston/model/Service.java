package com.example.aston.model;

import jakarta.persistence.*;


import java.util.Set;
import java.util.UUID;


@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private UUID id;
    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;

    @ManyToMany(mappedBy = "services")
    private Set<Attraction> attractions;

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

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public Set<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(Set<Attraction> attractions) {
        this.attractions = attractions;
    }
}