package com.example.hormone.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NamedQuery;


import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "activity")
public class Activity {
    @Id
    @Column(name = "userid", nullable = false)
    private String userid;

    @Column(name = "password", nullable = false)
    private String password;


}