package com.example.aston.service;

import com.example.aston.dto.AttractionServiceRequestDTO;
import com.example.aston.mapper.AttractionServiceMapper;
import com.example.aston.model.AttractionService;
import com.example.aston.model.ServiceType;
import com.example.aston.repository.AttractionServiceRepository;
import com.example.aston.service.attraction.AttractionServiceImpl;
import com.example.aston.service.service.AttractionServiceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AttractionServiceServiceTest {

    @Mock
    private AttractionServiceRepository serviceRepo;

    @Mock
    private AttractionServiceMapper serviceMapper;

    @InjectMocks
    private AttractionServiceServiceImpl attractionService;

    private AttractionService attractionServiceEntity;
    private AttractionServiceRequestDTO attractionServiceRequestDTO;
    private UUID uuid;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        uuid = UUID.randomUUID();
        attractionServiceEntity = new AttractionService();
        attractionServiceRequestDTO = new AttractionServiceRequestDTO("Test name","Test Description", ServiceType.RENTAL_SERVICE);

        when(serviceMapper.mapToAttractionServiceRequestDTO(attractionServiceEntity)).thenReturn(attractionServiceRequestDTO);
    }

    @Test
    void findById_ShouldReturnAttractionServiceRequestDTO_WhenServiceExists() {
        when(serviceRepo.findById(uuid)).thenReturn(Optional.of(attractionServiceEntity));

        AttractionServiceRequestDTO result = attractionService.findById(uuid);

        assertNotNull(result);
        assertEquals(attractionServiceRequestDTO, result);
        verify(serviceRepo, times(1)).findById(uuid);
    }

    @Test
    void findById_ShouldThrowRuntimeException_WhenServiceDoesNotExist() {
        when(serviceRepo.findById(uuid)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            attractionService.findById(uuid);
        });

        assertEquals("Attraction Service not found by id: " + uuid, exception.getMessage());
        verify(serviceRepo, times(1)).findById(uuid);
    }

    @Test
    void getAll_ShouldReturnListOfAttractionServiceRequestDTO_WhenServicesExist() {
        List<AttractionService> services = Collections.singletonList(attractionServiceEntity);
        when(serviceRepo.findAll()).thenReturn(services);
        when(serviceMapper.mapToAttractionServiceRequestDTO(services)).thenReturn(Collections.singletonList(attractionServiceRequestDTO));

        List<AttractionServiceRequestDTO> result = attractionService.getAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(attractionServiceRequestDTO, result.get(0));
        verify(serviceRepo, times(1)).findAll();
    }

    @Test
    void save_ShouldReturnAttractionServiceRequestDTO_WhenServiceIsSaved() {
        when(serviceRepo.save(attractionServiceEntity)).thenReturn(attractionServiceEntity);

        AttractionServiceRequestDTO result = attractionService.save(attractionServiceEntity);

        assertNotNull(result);
        assertEquals(attractionServiceRequestDTO, result);
        verify(serviceRepo, times(1)).save(attractionServiceEntity);
    }

    @Test
    void delete_ShouldDeleteService_WhenServiceExists() {
        doNothing().when(serviceRepo).deleteById(uuid);

        attractionService.delete(uuid);

        verify(serviceRepo, times(1)).deleteById(uuid);
    }
}
