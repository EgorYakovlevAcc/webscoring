package com.example.demo.service;

import com.example.demo.model.Prediction;
import com.example.demo.repo.PredictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PredictionServiceImpl implements PredictionService {
    @Autowired
    private PredictionRepository predictionRepository;

    @Override
    public Prediction findPredictionById(Integer id) {
        return predictionRepository.findPredictionById(id);
    }

    @Override
    public void save(Prediction prediction) {
        predictionRepository.save(prediction);
    }

    @Override
    public void delete(Prediction prediction) {
        predictionRepository.delete(prediction);
    }
}
