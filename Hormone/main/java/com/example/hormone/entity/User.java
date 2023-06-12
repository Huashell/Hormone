package com.example.hormone.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @Column(name = "userid", nullable = false)
    private String userid;

    @Column(name = "iconurl",nullable = false)
    private String iconurl;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;




  /*  @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "photo", nullable = false)
    private String photo;*/


}