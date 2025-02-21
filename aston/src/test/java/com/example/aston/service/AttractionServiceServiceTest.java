package com.example.aston.service;

import com.example.aston.model.AttractionService;
import com.example.aston.repository.AttractionServiceRepository;
import com.example.aston.service.service.AttractionServiceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;


public class AttractionServiceServiceTest {

    @Mock
    private AttractionServiceRepository serviceRepo;

    @InjectMocks
    private AttractionServiceServiceImpl attServService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllAttractionService() {
        AttractionService attrService1 = new AttractionService();
        AttractionService attrService2 = new AttractionService();
        List<AttractionService> services = Arrays.asList(attrService1, attrService2);

        when(serviceRepo.findAll()).thenReturn(services);

        List<AttractionService> result = attServService.getAllAttractionService();

        assertEquals(2, result.size());
        verify(serviceRepo, times(1)).findAll();
    }

    @Test
    void testGetAttractionServiceById() {
        UUID id = UUID.randomUUID();
        AttractionService attrService = new AttractionService();
        attrService.setId(id);

        when(serviceRepo.findById(id)).thenReturn(Optional.of(attrService));

        AttractionService result = attServService.getAttractionServiceById(id);

        assertNotNull(result);
        assertEquals(id, result.getId());
        verify(serviceRepo, times(1)).findById(id);
    }

    @Test
    void testGetAttractionServiceById_NotFound() {
        UUID id = UUID.randomUUID();

        when(serviceRepo.findById(id)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            attServService.getAttractionServiceById(id);
        });

        assertEquals("Attraction service not found by id: " + id, exception.getMessage());
        verify(serviceRepo, times(1)).findById(id);
    }

    @Test
    void testSaveAttractionService() {
        AttractionService attrService = new AttractionService();

        when(serviceRepo.save(attrService)).thenReturn(attrService);

        AttractionService result = attServService.saveAttractionService(attrService);

        assertNotNull(result);
        verify(serviceRepo, times(1)).save(attrService);
    }

    @Test
    void testDeleteAddress() {
        UUID id = UUID.randomUUID();

        attServService.deleteAttractionService(id);

        verify(serviceRepo, times(1)).deleteById(id);
    }
}
