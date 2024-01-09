package com.example.hormone.service.impl;

/**
 * @param
 * @return
 **/
import com.example.hormone.entity.Comments;
import com.example.hormone.repository.CommentsRepository;
import com.example.hormone.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentsServiceImpl implements CommentsService {

    private final CommentsRepository commentsRepository;

    @Autowired
    public CommentsServiceImpl(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    @Override
    public Comments saveComment(Comments comment) {
        return commentsRepository.save(comment);
    }

    @Override
    public Comments getCommentById(int commentId) {
        Optional<Comments> optionalComments = commentsRepository.findById(commentId);
        return optionalComments.orElse(null);
    }

    // Implement other service methods if needed
}
