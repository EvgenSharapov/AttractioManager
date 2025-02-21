package com.example.aston.repository;

import com.example.aston.model.AttractionService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface AttractionServiceRepository extends JpaRepository<AttractionService, UUID> {
}