package com.example.hormone.entity;

/**
 * @param
 * @return
 **/
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "newsId")
    private int newsId;

    @Column(name = "userId")
    private int userId;

    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Column(name = "content", length = 255, nullable = false)
    private String content;

    @Column(name = "image", length = 255)
    private String image;

    @Column(name = "releaseTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date releaseTime;

    @Column(name = "status")
    private int status;

    // Getter and Setter methods
}

