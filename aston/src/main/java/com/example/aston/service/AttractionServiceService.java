package com.example.aston.service;
import com.example.aston.model.AttractionService;
import com.example.aston.repository.AttractionServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AttractionServiceService {

    private final AttractionServiceRepository serviceRepo;

    public AttractionServiceService(AttractionServiceRepository serviceRepo) {
        this.serviceRepo = serviceRepo;
    }


    public List<AttractionService> getAllAttractionService() {
        return serviceRepo.findAll();
    }

    public AttractionService getAttractionServiceById(UUID id) {
        return serviceRepo.findById(id).orElseThrow(
                ()->new RuntimeException("Attraction service not found by id: "+id));
    }

    public AttractionService saveAttractionService(AttractionService service) {
        return serviceRepo.save(service);
    }

    public void deleteAttractionService(UUID id) {
        serviceRepo.deleteById(id);
    }


}
