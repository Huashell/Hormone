package com.example.hormone.service;

import com.example.hormone.entity.Comments;

public interface CommentsService {
    Comments saveComment(Comments comment);

    Comments getCommentById(int commentId);

    // Other service methods if needed
}
