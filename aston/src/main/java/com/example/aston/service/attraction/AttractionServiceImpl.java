package com.example.aston.service.attraction;

import com.example.aston.dto.AttractionRequestDTO;
import com.example.aston.mapper.AttractionMapper;
import com.example.aston.model.Address;
import com.example.aston.model.Attraction;
import com.example.aston.repository.AttractionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AttractionServiceImpl implements AttractionService{

    private final AttractionRepository attractionRepo;
    private final AttractionMapper attractionMapper;



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

    public List<Attraction>  getAttractionsByService(String service){
        return attractionRepo.findByServices_Name(service);
    }




    @Override
    public AttractionRequestDTO findById(UUID id) {
        log.debug("Find Attraction by id: {}", id);

        Attraction attraction = attractionRepo.findById(id).orElseThrow(
                () ->
                        new RuntimeException("Attraction not found by id: " + id));

        return attractionMapper.mapToAttractionRequestDTO(attraction);
    }

    @Override
    public List<AttractionRequestDTO> getAll() {
        log.debug("Find all Attractions");

        List<Attraction> attractions = attractionRepo.findAll();

        return attractionMapper.mapToAttractionRequestDTO(attractions);
    }

    @Override
    public AttractionRequestDTO save(Attraction attraction) {
        log.debug("Save Attraction: {}",attraction);
        attractionRepo.save(attraction);

        return attractionMapper.mapToAttractionRequestDTO(attraction);
    }

    @Override
    public void delete(UUID id) {
        log.debug("Delete Attraction by id: {}",id);

        attractionRepo.deleteById(id);

    }
}