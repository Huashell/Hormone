package com.example.hormone.entity;

/**
 * @param
 * @return
 **/
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "favors")
public class Favors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favorId")
    private int favorId;

    @Column(name = "userId")
    private int userId;

    @Column(name = "newsId")
    private int newsId;

    @Column(name = "favorTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date favorTime;

    @Column(name = "status")
    private int status;

    // Getter and Setter methods
}

