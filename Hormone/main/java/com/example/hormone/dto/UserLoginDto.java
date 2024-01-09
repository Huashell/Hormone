package com.example.hormone.dto;

import lombok.Data;

/**
 * @param
 * @return
 **/
@Data
public class UserLoginDto extends UserDto {

    private String password;

    private Boolean isAdmin;
}

