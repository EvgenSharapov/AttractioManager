package com.example.aston.mapper;

import com.example.aston.dto.AttractionServiceRequestDTO;
import com.example.aston.model.AttractionService;
import com.example.aston.model.ServiceType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AttractionServiceMapperTest {

    @InjectMocks
    private AttractionServiceMapper attractionServiceMapper;

    @Test
    void mapToAttractionServiceRequestDTO_ShouldMapSingleServiceCorrectly() {
        AttractionService service = new AttractionService();
        service.setName("Test name");
        service.setDescription("Test description");
        service.setServiceType(ServiceType.PHOTOGRAPHY_SERVICE);

        AttractionServiceRequestDTO result = attractionServiceMapper.mapToAttractionServiceRequestDTO(service);

        assertNotNull(result);
        assertEquals("Test name", result.name());
        assertEquals("Test description", result.description());
        assertEquals(ServiceType.PHOTOGRAPHY_SERVICE, result.type());
    }

    @Test
    void mapToAttractionServiceRequestDTO_ShouldMapListOfServicesCorrectly() {
        AttractionService service = new AttractionService();
        service.setName("Test name");
        service.setDescription("Test description");
        service.setServiceType(ServiceType.PHOTOGRAPHY_SERVICE);

        List<AttractionService> services = Collections.singletonList(service);

        List<AttractionServiceRequestDTO> result = attractionServiceMapper.mapToAttractionServiceRequestDTO(services);

        assertNotNull(result);
        assertEquals(1, result.size());

        AttractionServiceRequestDTO dto = result.get(0);
        assertEquals("Test name", dto.name());
        assertEquals("Test description", dto.description());
        assertEquals(ServiceType.PHOTOGRAPHY_SERVICE, dto.type());
    }

    @Test
    void mapToAttractionServiceRequestDTO_ShouldReturnEmptyList_WhenInputListIsEmpty() {
        List<AttractionService> services = Collections.emptyList();

        List<AttractionServiceRequestDTO> result = attractionServiceMapper.mapToAttractionServiceRequestDTO(services);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}