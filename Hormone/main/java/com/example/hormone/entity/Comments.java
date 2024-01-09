package com.example.hormone.entity;

/**
 * @param
 * @return
 **/
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentId")
    private int commentId;

    @Column(name = "userId")
    private int userId;

    @Column(name = "newsId")
    private int newsId;

    @Column(name = "comment", length = 255, nullable = false)
    private String comment;

    @Column(name = "replyUser", length = 20)
    private String replyUser;

    @Column(name = "commentTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentTime;

    @Column(name = "status")
    private int status;

    // Getter and Setter methods
}
