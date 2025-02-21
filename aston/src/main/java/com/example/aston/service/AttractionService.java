package com.example.aston.service;

import com.example.aston.model.Attraction;
import com.example.aston.repository.AttractionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AttractionService {

    private final AttractionRepository attractionRepo;

    public AttractionService(AttractionRepository attractionRepository) {
        this.attractionRepo = attractionRepository;
    }

    public List<Attraction> getAllAttractions() {
        return attractionRepo.findAll();
    }

    public Attraction getAttractionById(UUID id) {
        return attractionRepo.findById(id).orElseThrow(
                ()->new RuntimeException("Attraction not found by id: "+id));
    }

    public Attraction saveAttraction(Attraction attraction) {
        return attractionRepo.save(attraction);
    }

    public void deleteAttraction(UUID id) {
        attractionRepo.deleteById(id);
    }

    public List<Attraction> getAttractionsByCity(String city) {
        return attractionRepo.findByAddress_City(city);
    }

    public List<Attraction> getAttractionsByRegion(String region) {
        return attractionRepo.findByAddress_Region(region);
    }

    public List<Attraction> searchAttractionsByName(String name) {
        return attractionRepo.findByNameContaining(name);
    }

    public List<Attraction>  getAttractionByService(String service){
        return attractionRepo.findByServices_Name(service);
    }
}