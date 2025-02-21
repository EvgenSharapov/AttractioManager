package com.example.aston.repository;


import com.example.aston.model.TicketInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface TicketInfoRepository extends JpaRepository<TicketInfo, UUID> {
}