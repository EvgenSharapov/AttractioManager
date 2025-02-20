package com.example.aston.repository;

import com.example.aston.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface ServiceRepository extends JpaRepository<Service, Long> {
}