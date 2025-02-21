package com.example.aston.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


@Entity
@Getter
@Setter
@NoArgsConstructor

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
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