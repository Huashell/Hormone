package com.example.hormone.service.impl;

/**
 * @param
 * @return
 **/
import com.example.hormone.entity.Training;
import com.example.hormone.repository.TrainingRepository;
import com.example.hormone.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrainingServiceImpl implements TrainingService {

    private final TrainingRepository trainingRepository;

    @Autowired
    public TrainingServiceImpl(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @Override
    public Training saveTraining(Training training) {
        return trainingRepository.save(training);
    }

    @Override
    public Training getTrainingById(int id) {
        Optional<Training> optionalTraining = trainingRepository.findById(id);
        return optionalTraining.orElse(null);
    }

    // Implement other service methods if needed
}

