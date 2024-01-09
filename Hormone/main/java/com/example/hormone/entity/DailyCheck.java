package com.example.hormone.entity;

/**
 * @param
 * @return
 **/
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dailycheck")
public class DailyCheck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "userId")
    private int userId;

    @Column(name = "checkDate")
    @Temporal(TemporalType.DATE)
    private Date checkDate;

    @Column(name = "checkTime")
    @Temporal(TemporalType.TIME)
    private Date checkTime;

    @Column(name = "status")
    private int status;

    // Getter and Setter methods
}

