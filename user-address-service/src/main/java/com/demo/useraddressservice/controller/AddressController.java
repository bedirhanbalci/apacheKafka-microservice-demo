package com.demo.useraddressservice.controller;

import com.demo.useraddressservice.entity.Address;
import com.demo.useraddressservice.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/{userId}")
    public Address getAddressByUserId(@PathVariable Long userId){
        return addressService.getAddressByUserId(userId);
    }
}
