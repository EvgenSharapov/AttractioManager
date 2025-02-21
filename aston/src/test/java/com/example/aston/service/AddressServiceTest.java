package com.example.aston.service;

import com.example.aston.model.Address;
import com.example.aston.repository.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class AddressServiceTest {

        @Mock
        private AddressRepository addressRepo;

        @InjectMocks
        private AddressService addressService;

        @BeforeEach
        void setUp() {
            MockitoAnnotations.openMocks(this);
        }

        @Test
        void testGetAllAddress() {
            Address address1 = new Address();
            Address address2 = new Address();
            List<Address> addresses = Arrays.asList(address1, address2);

            when(addressRepo.findAll()).thenReturn(addresses);

            List<Address> result = addressService.getAllAddresses();

            assertEquals(2, result.size());
            verify(addressRepo, times(1)).findAll();
        }

        @Test
        void testGetAddressById() {
            UUID id = UUID.randomUUID();
            Address address = new Address();
            address.setId(id);

            when(addressRepo.findById(id)).thenReturn(Optional.of(address));

            Address result = addressService.getAddressById(id);

            assertNotNull(result);
            assertEquals(id, result.getId());
            verify(addressRepo, times(1)).findById(id);
        }

        @Test
        void testGetAddressById_NotFound() {
            UUID id = UUID.randomUUID();

            when(addressRepo.findById(id)).thenReturn(Optional.empty());

            Exception exception = assertThrows(RuntimeException.class, () -> {
                addressService.getAddressById(id);
            });

            assertEquals("Address not found by id: " + id, exception.getMessage());
            verify(addressRepo, times(1)).findById(id);
        }

        @Test
        void testSaveAddress() {
            Address address = new Address();

            when(addressRepo.save(address)).thenReturn(address);

            Address result = addressService.saveAddress(address);

            assertNotNull(result);
            verify(addressRepo, times(1)).save(address);
        }

        @Test
        void testDeleteAddress() {
            UUID id = UUID.randomUUID();

            addressService.deleteAddress(id);

            verify(addressRepo, times(1)).deleteById(id);
        }

}
