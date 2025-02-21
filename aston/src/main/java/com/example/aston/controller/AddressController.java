package com.example.aston.controller;

import com.example.aston.dto.AddressRequestDTO;
import com.example.aston.model.Address;
import com.example.aston.service.address.AddressServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/address")
public class AddressController {

        private final AddressServiceImpl addressService;

    public AddressController(AddressServiceImpl addressService) {
        this.addressService = addressService;
    }


    @GetMapping
        public List<AddressRequestDTO> getAllAddresses() {
            return addressService.getAll();
        }

        @GetMapping("/{id}")
        public AddressRequestDTO getAddressById(@PathVariable UUID id) {
            return addressService.findById(id);
        }

        @PostMapping
        public AddressRequestDTO createAddress(@RequestBody Address address) {
            return addressService.save(address);
        }

        @PutMapping("/{id}")
        public AddressRequestDTO updateAddress(@PathVariable UUID id, @RequestBody Address address) {
            address.setId(id);
            return addressService.save(address);
        }

        @DeleteMapping("/{id}")
        public void deleteAddress(@PathVariable UUID id) {
            addressService.delete(id);
        }

    }
