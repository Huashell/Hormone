package com.example.hormone.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private final String userid;
    private final String password;
}
