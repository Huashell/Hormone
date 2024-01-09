package com.example.hormone.entity;

/**
 * @param
 * @return
 **/
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "training")
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "userId")
    private int userId;

    @Column(name = "trainTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trainTime;

    @Column(name = "duration")
    private int duration;

    @Column(name = "status")
    private int status;

    // Getter and Setter methods
}

