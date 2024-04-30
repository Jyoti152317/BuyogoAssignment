package com.example.buyogo.service;

import java.util.List;

import com.example.buyogo.entity.TrainingCenter;

public interface TrainingCenterService {

    TrainingCenter createTrainingCenter(TrainingCenter trainingCenter);

    List<TrainingCenter> getAllTrainingCenters();

    TrainingCenter getTrainingCenterById(Long id);

    TrainingCenter updateTrainingCenter(Long id, TrainingCenter trainingCenter);

    void deleteTrainingCenter(Long id);
}
