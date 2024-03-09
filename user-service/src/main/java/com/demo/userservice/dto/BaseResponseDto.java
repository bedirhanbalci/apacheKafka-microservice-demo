package com.demo.userservice.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BaseResponseDto {

    private Long id;

    private Date createdAt;

    private Date updatedAt;

}
