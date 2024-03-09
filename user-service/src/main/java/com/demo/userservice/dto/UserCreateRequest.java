package com.demo.userservice.dto;

import lombok.Data;

@Data
public class UserCreateRequest {

    private String firstName;

    private String lastName;

    private String email;

    private String addressText;

}
