package com.example.hormone.controller;

/**
 * @param
 * @return
 **/
import com.example.hormone.entity.Training;
import com.example.hormone.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/training")
public class TrainingController {

    private final TrainingService trainingService;

    @Autowired
    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @PostMapping
    public ResponseEntity<Training> saveTraining(@RequestBody Training training) {
        Training savedTraining = trainingService.saveTraining(training);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTraining);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Training> getTrainingById(@PathVariable int id) {
        Training training = trainingService.getTrainingById(id);
        if (training != null) {
            return ResponseEntity.ok(training);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Other controller endpoints if needed
}
