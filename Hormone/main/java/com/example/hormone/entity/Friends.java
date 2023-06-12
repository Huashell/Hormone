package com.example.hormone.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "friends")
@Data
public class Friends {
    @Id
    @Column(name = "id", nullable = false)
    private String id;


    @Column(name = "userid", nullable = false)
    private String userid;

    @Id
    @Column(name = "friendid", nullable = false)
    private String friendid;
}
