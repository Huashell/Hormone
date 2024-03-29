package com.example.hormone.repository;

import com.example.hormone.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Integer> {
    // Add custom query methods if needed
}
