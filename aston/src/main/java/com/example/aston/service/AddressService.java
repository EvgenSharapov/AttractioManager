package com.example.aston.service;

import com.example.aston.model.Address;
import com.example.aston.model.Attraction;
import com.example.aston.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AddressService {

    private final AddressRepository addressRepo;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepo = addressRepository;
    }

    public List<Address> getAllAddresses() {
        return addressRepo.findAll();
    }

    public Address getAddressById(UUID id) {
        return addressRepo.findById(id).orElseThrow(
                ()->new RuntimeException("Address not found by id: "+id));
    }

    public Address saveAddress(Address address) {
        return addressRepo.save(address);
    }

    public void deleteAddress(UUID id) {
        addressRepo.deleteById(id);
    }






}