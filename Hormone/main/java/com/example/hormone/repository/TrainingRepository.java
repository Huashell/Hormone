package com.example.hormone.repository;

import com.example.hormone.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Integer> {
    // Add custom query methods if needed
}
