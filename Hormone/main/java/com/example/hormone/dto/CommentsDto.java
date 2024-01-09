package com.example.hormone.dto;

/**
 * @param
 * @return
 **/
import lombok.Data;

import java.util.Date;
@Data
public class CommentsDto {
    private int commentId;
    private int userId;
    private int newsId;
    private String content;
    private Date commentTime;
    private int status;

    // Getter and Setter methods
}
