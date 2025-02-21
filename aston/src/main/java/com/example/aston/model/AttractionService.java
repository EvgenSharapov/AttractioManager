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
public class AttractionService {
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


}