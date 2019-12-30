package com.example.demo.service;

import com.example.demo.model.Prediction;

public interface PredictionService {
    Prediction findPredictionById(Integer id);
    void save(Prediction prediction);
    void delete(Prediction prediction);
}
