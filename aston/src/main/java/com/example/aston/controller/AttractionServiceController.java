package com.example.aston.controller;

import com.example.aston.model.AttractionService;
import com.example.aston.service.AttractionServiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/services")
public class AttractionServiceController {

    private final AttractionServiceService attServService;

    public AttractionServiceController(AttractionServiceService service) {
        this.attServService = service;
    }


    @GetMapping
        public List<AttractionService> getAllAttractionServices() {
            return attServService.getAllAttractionService();
        }

        @GetMapping("/{id}")
        public AttractionService getAttractionServiceById(@PathVariable UUID id) {
            return attServService.getAttractionServiceById(id);
        }

        @PostMapping
        public AttractionService createAttractionService(@RequestBody AttractionService service) {
            return attServService.saveAttractionService(service);
        }

        @PutMapping("/{id}")
        public AttractionService updateAttractionService(@PathVariable UUID id, @RequestBody AttractionService service) {
            service.setId(id);
            return attServService.saveAttractionService(service);
        }

        @DeleteMapping("/{id}")
        public void deleteAttraction(@PathVariable UUID id) {
            attServService.deleteAttractionService(id);
        }


}
