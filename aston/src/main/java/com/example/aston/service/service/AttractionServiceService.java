package com.example.aston.service.service;

import com.example.aston.dto.AttractionServiceRequestDTO;
import com.example.aston.model.AttractionService;

import java.util.List;
import java.util.UUID;

public interface AttractionServiceService {

    AttractionServiceRequestDTO findById(UUID id);

    List<AttractionServiceRequestDTO> getAll();

    AttractionServiceRequestDTO save(AttractionService service);

    void delete(UUID id);
}
