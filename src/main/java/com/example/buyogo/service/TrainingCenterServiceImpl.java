package com.example.buyogo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.buyogo.entity.TrainingCenter;
import com.example.buyogo.exception.TrainingCenterNotFoundException;
import com.example.buyogo.repository.TrainingCenterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingCenterServiceImpl implements TrainingCenterService {

    @Autowired
    private TrainingCenterRepository trainingCenterRepository;

    @Override
    public TrainingCenter createTrainingCenter(TrainingCenter trainingCenter) {
        // Set createdOn timestamp (Epoch time) here before saving
        trainingCenter.setCreatedOn(System.currentTimeMillis());
        return trainingCenterRepository.save(trainingCenter);
    }

    @Override
    public List<TrainingCenter> getAllTrainingCenters() {
        return trainingCenterRepository.findAll();
    }

    @Override
    public TrainingCenter getTrainingCenterById(Long id) {
        Optional<TrainingCenter> optionalTrainingCenter = trainingCenterRepository.findById(id);
        return optionalTrainingCenter.orElseThrow(() -> new TrainingCenterNotFoundException("Training center not found with id: " + id));
    }

    @Override
    public TrainingCenter updateTrainingCenter(Long id, TrainingCenter updatedTrainingCenter) {
        TrainingCenter existingTrainingCenter = getTrainingCenterById(id);
        // Update existingTrainingCenter properties based on updatedTrainingCenter
        existingTrainingCenter.setCenterName(updatedTrainingCenter.getCenterName());
        existingTrainingCenter.setAddress(updatedTrainingCenter.getAddress());
        existingTrainingCenter.setStudentCapacity(updatedTrainingCenter.getStudentCapacity());
        existingTrainingCenter.setCoursesOffered(updatedTrainingCenter.getCoursesOffered());
        existingTrainingCenter.setContactEmail(updatedTrainingCenter.getContactEmail());
        existingTrainingCenter.setContactPhone(updatedTrainingCenter.getContactPhone());
        return trainingCenterRepository.save(existingTrainingCenter);
    }

    @Override
    public void deleteTrainingCenter(Long id) {
        if (!trainingCenterRepository.existsById(id)) {
            throw new TrainingCenterNotFoundException("Training center not found with id: " + id);
        }
        trainingCenterRepository.deleteById(id);
    }
}

