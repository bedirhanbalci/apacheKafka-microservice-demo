package com.demo.userservice.controller;

import com.demo.userservice.dto.AddressResponseDto;
import com.demo.userservice.dto.UserCreateRequest;
import com.demo.userservice.dto.UserResponse;
import com.demo.userservice.entity.User;
import com.demo.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private RestTemplate restTemplate = new RestTemplate();
    private final UserService userService;

    @PostMapping
    public User create(@RequestBody UserCreateRequest userCreateRequest) {
        return userService.create(userCreateRequest);
    }

    @GetMapping("/{userId}")
    public UserResponse getUserAddress(@PathVariable Long userId) {

        String url = String.format("http://localhost:8002/api/address/%s", userId);
        ResponseEntity<AddressResponseDto> address = restTemplate.getForEntity(url, AddressResponseDto.class);

        User user = userService.getUserById(address.getBody().getUserId());
        return UserResponse.getUserResponseWithAddress(user, address.getBody());

    }
}
