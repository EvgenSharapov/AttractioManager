package com.example.aston.service;

import com.example.aston.model.Attraction;
import com.example.aston.repository.AttractionRepository;
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

class AttractionServiceTest {

    @Mock
    private AttractionRepository attractionRepo;

    @InjectMocks
    private AttractionService attractionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllAttractions() {
        Attraction attraction1 = new Attraction();
        Attraction attraction2 = new Attraction();
        List<Attraction> attractions = Arrays.asList(attraction1, attraction2);

        when(attractionRepo.findAll()).thenReturn(attractions);

        List<Attraction> result = attractionService.getAllAttractions();

        assertEquals(2, result.size());
        verify(attractionRepo, times(1)).findAll();
    }

    @Test
    void testGetAttractionById() {
        UUID id = UUID.randomUUID();
        Attraction attraction = new Attraction();
        attraction.setId(id);

        when(attractionRepo.findById(id)).thenReturn(Optional.of(attraction));

        Attraction result = attractionService.getAttractionById(id);

        assertNotNull(result);
        assertEquals(id, result.getId());
        verify(attractionRepo, times(1)).findById(id);
    }

    @Test
    void testGetAttractionById_NotFound() {
        UUID id = UUID.randomUUID();

        when(attractionRepo.findById(id)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            attractionService.getAttractionById(id);
        });

        assertEquals("Attraction not found by id: " + id, exception.getMessage());
        verify(attractionRepo, times(1)).findById(id);
    }

    @Test
    void testSaveAttraction() {
        Attraction attraction = new Attraction();

        when(attractionRepo.save(attraction)).thenReturn(attraction);

        Attraction result = attractionService.saveAttraction(attraction);

        assertNotNull(result);
        verify(attractionRepo, times(1)).save(attraction);
    }

    @Test
    void testDeleteAttraction() {
        UUID id = UUID.randomUUID();

        attractionService.deleteAttraction(id);

        verify(attractionRepo, times(1)).deleteById(id);
    }

    @Test
    void testGetAttractionsByCity() {
        String city = "Moscow";
        Attraction attraction1 = new Attraction();
        Attraction attraction2 = new Attraction();
        List<Attraction> attractions = Arrays.asList(attraction1, attraction2);

        when(attractionRepo.findByAddress_City(city)).thenReturn(attractions);

        List<Attraction> result = attractionService.getAttractionsByCity(city);

        assertEquals(2, result.size());
        verify(attractionRepo, times(1)).findByAddress_City(city);
    }

    @Test
    void testGetAttractionsByRegion() {
        String region = "Moscow region";
        Attraction attraction1 = new Attraction();
        Attraction attraction2 = new Attraction();
        List<Attraction> attractions = Arrays.asList(attraction1, attraction2);

        when(attractionRepo.findByAddress_Region(region)).thenReturn(attractions);

        List<Attraction> result = attractionService.getAttractionsByRegion(region);

        assertEquals(2, result.size());
        verify(attractionRepo, times(1)).findByAddress_Region(region);
    }

    @Test
    void testSearchAttractionsByName() {
        String name = "Zoo";
        Attraction attraction1 = new Attraction();
        Attraction attraction2 = new Attraction();
        List<Attraction> attractions = Arrays.asList(attraction1, attraction2);

        when(attractionRepo.findByNameContaining(name)).thenReturn(attractions);

        List<Attraction> result = attractionService.searchAttractionsByName(name);

        assertEquals(2, result.size());
        verify(attractionRepo, times(1)).findByNameContaining(name);
    }

    @Test
    void testGetAttractionsByService() {
        String service = "Tour Guide";
        Attraction attraction1 = new Attraction();
        Attraction attraction2 = new Attraction();
        List<Attraction> attractions = Arrays.asList(attraction1, attraction2);

        when(attractionRepo.findByServices_Name(service)).thenReturn(attractions);

        List<Attraction> result = attractionService.getAttractionsByService(service);

        assertEquals(2, result.size());
        verify(attractionRepo, times(1)).findByServices_Name(service);
    }

}