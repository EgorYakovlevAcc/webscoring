package com.example.demo.service.match;

import com.example.demo.model.Match;

import java.util.Date;

public interface MatchService {
    Match findMatchById(Integer id);
    Match findMatchByDate(String date);
    void save(Match match);
}
