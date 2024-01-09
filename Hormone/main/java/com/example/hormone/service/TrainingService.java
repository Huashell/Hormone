package com.example.hormone.service;

import com.example.hormone.entity.Training;

/**
 * @param
 * @return
 **/
public interface TrainingService {
    Training saveTraining(Training training);

    Training getTrainingById(int id);

    // Other service methods if needed
}
