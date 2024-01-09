package com.example.hormone.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserDto implements Serializable {
    private int userId;

    private String username;


    private Boolean isAdmin;

    private String sex;

    private double height;

    private double weight;

    private boolean enabled;
}
