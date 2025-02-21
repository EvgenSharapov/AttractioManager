package com.example.aston.mapper;

import com.example.aston.dto.AttractionRequestDTO;
import com.example.aston.dto.AttractionServiceRequestDTO;
import com.example.aston.model.Attraction;
import com.example.aston.model.AttractionService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AttractionServiceMapper {

    public AttractionServiceRequestDTO mapToAttractionServiceRequestDTO(AttractionService service) {
        return AttractionServiceRequestDTO.builder()
                .name(service.getName())
                .description(service.getDescription())
                .build();
    }
    public List<AttractionServiceRequestDTO> mapToAttractionServiceRequestDTO(List<AttractionService> services) {
        return services.stream()
                .map(this::mapToAttractionServiceRequestDTO)
                .collect(Collectors.toList());
    }
}
