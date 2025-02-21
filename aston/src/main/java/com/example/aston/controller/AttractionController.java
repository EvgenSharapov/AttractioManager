package com.example.aston.controller;

import com.example.aston.model.Attraction;
import com.example.aston.service.attraction.AttractionServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/attractions")
public class AttractionController {

    private final AttractionServiceImpl attractionService;

    public AttractionController(AttractionServiceImpl attractionService) {
        this.attractionService = attractionService;
    }

    @GetMapping
    public List<Attraction> getAllAttractions() {
        return attractionService.getAllAttractions();
    }

    @GetMapping("/{id}")
    public Attraction getAttractionById(@PathVariable UUID id) {
        return attractionService.getAttractionById(id);
    }

    @PostMapping
    public Attraction createAttraction(@RequestBody Attraction attraction) {
        return attractionService.saveAttraction(attraction);
    }

    @PutMapping("/{id}")
    public Attraction updateAttraction(@PathVariable UUID id, @RequestBody Attraction attraction) {
        attraction.setId(id);
        return attractionService.saveAttraction(attraction);
    }

    @DeleteMapping("/{id}")
    public void deleteAttraction(@PathVariable UUID id) {
        attractionService.deleteAttraction(id);
    }

    @GetMapping("/city/{city}")
    public List<Attraction> getAttractionsByCity(@PathVariable String city) {
        return attractionService.getAttractionsByCity(city);
    }

    @GetMapping("/region/{region}")
    public List<Attraction> getAttractionsByRegion(@PathVariable String region) {
        return attractionService.getAttractionsByRegion(region);
    }

    @GetMapping("/search")
    public List<Attraction> searchAttractionsByName(@RequestParam String name) {
        return attractionService.searchAttractionsByName(name);
    }
    @GetMapping("/service/{name}")
    public List<Attraction> getAttractionsByService(@PathVariable String name) {
        return attractionService.getAttractionsByService(name);
    }
}