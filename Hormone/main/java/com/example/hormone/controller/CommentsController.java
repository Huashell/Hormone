package com.example.hormone.controller;

/**
 * @param
 * @return
 **/
import com.example.hormone.entity.Comments;
import com.example.hormone.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentsController {

    private final CommentsService commentsService;

    @Autowired
    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @PostMapping
    public ResponseEntity<Comments> saveComment(@RequestBody Comments comment) {
        Comments savedComment = commentsService.saveComment(comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedComment);
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<Comments> getCommentById(@PathVariable int commentId) {
        Comments comment = commentsService.getCommentById(commentId);
        if (comment != null) {
            return ResponseEntity.ok(comment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Other controller endpoints if needed
}
