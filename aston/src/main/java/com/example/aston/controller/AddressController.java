package com.example.aston.controller;

import com.example.aston.model.Address;
import com.example.aston.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/address")
public class AddressController {

        private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }


    @GetMapping
        public List<Address> getAllAddresses() {
            return addressService.getAllAddresses();
        }

        @GetMapping("/{id}")
        public Address getAddressById(@PathVariable UUID id) {
            return addressService.getAddressById(id);
        }

        @PostMapping
        public Address createAddress(@RequestBody Address address) {
            return addressService.saveAddress(address);
        }

        @PutMapping("/{id}")
        public Address updateAddress(@PathVariable UUID id, @RequestBody Address address) {
            address.setId(id);
            return addressService.saveAddress(address);
        }

        @DeleteMapping("/{id}")
        public void deleteAddress(@PathVariable UUID id) {
            addressService.deleteAddress(id);
        }

    }
