package com.example.buyogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.buyogo.entity.TrainingCenter;
import com.example.buyogo.service.TrainingCenterService;

import java.util.List;

@RestController
@RequestMapping("/api/training-centers")
public class TrainingCenterController {

    @Autowired
    private TrainingCenterService trainingCenterService;

    @PostMapping
    public ResponseEntity<TrainingCenter> createTrainingCenter(
            @RequestBody @Validated TrainingCenter trainingCenter) {
        TrainingCenter createdCenter = trainingCenterService.createTrainingCenter(trainingCenter);
        return new ResponseEntity<>(createdCenter, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters() {
        List<TrainingCenter> trainingCenters = trainingCenterService.getAllTrainingCenters();
        return ResponseEntity.ok(trainingCenters);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainingCenter> getTrainingCenterById(@PathVariable Long id) {
        TrainingCenter trainingCenter = trainingCenterService.getTrainingCenterById(id);
        return ResponseEntity.ok(trainingCenter);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrainingCenter> updateTrainingCenter(
            @PathVariable Long id, @RequestBody @Validated TrainingCenter updatedCenter) {
        TrainingCenter updatedTrainingCenter = trainingCenterService.updateTrainingCenter(id, updatedCenter);
        return ResponseEntity.ok(updatedTrainingCenter);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrainingCenter(@PathVariable Long id) {
        trainingCenterService.deleteTrainingCenter(id);
        return ResponseEntity.noContent().build();
    }
}

