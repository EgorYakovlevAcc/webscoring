package com.example.demo.repo;

import com.example.demo.model.Prediction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PredictionRepository extends JpaRepository<Prediction, Integer> {
    Prediction findPredictionById(Integer id);
}
