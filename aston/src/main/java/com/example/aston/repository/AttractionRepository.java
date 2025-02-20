package com.example.aston.repository;

import com.example.aston.model.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


public interface AttractionRepository extends JpaRepository<Attraction, Long> {
    List<Attraction> findByAddress_City(String city);
    List<Attraction> findByAddress_Region(String region);
    List<Attraction> findByNameContaining(String name);
}