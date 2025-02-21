package com.example.aston.service;

import com.example.aston.model.Address;
import com.example.aston.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepo;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepo = addressRepository;
    }

    public List<Address> getAllAddresses() {
        return addressRepo.findAll();
    }



}