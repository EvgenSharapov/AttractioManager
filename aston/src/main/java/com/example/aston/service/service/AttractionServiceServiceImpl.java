package com.example.aston.service.service;
import com.example.aston.dto.AttractionServiceRequestDTO;
import com.example.aston.mapper.AttractionServiceMapper;
import com.example.aston.model.Address;
import com.example.aston.model.AttractionService;
import com.example.aston.repository.AttractionServiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AttractionServiceServiceImpl implements AttractionServiceService{

    private final AttractionServiceRepository serviceRepo;
    private final AttractionServiceMapper serviceMapper;



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


    @Override
    public AttractionServiceRequestDTO findById(UUID id) {
        log.debug("Find Attraction Service by id: {}", id);

        AttractionService service = serviceRepo.findById(id).orElseThrow(
                () ->
                        new RuntimeException("Attraction Service not found by id: " + id));
        return serviceMapper.mapToAttractionServiceRequestDTO(service);
    }

    @Override
    public List<AttractionServiceRequestDTO> getAll() {
        log.debug("Find all Attraction Service");

        List<AttractionService> services = serviceRepo.findAll();

        return serviceMapper.mapToAttractionServiceRequestDTO(services);
    }

    @Override
    public AttractionServiceRequestDTO save(AttractionService service) {
        log.debug("Save Attraction Service: {}",service);
        serviceRepo.save(service);

        return serviceMapper.mapToAttractionServiceRequestDTO(service);
    }

    @Override
    public void delete(UUID id) {
        log.debug("Delete Attraction Service by id: {}",id);

        serviceRepo.deleteById(id);

    }
}
