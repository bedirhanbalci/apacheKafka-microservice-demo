package com.demo.useraddressservice.service;

import com.demo.useraddressservice.entity.Address;
import com.demo.useraddressservice.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public Address save(Address address) {
        return addressRepository.save(address);
    }

    public Address getAddressByUserId(Long userId) {
        return addressRepository.findByUserId(userId);
    }
}
