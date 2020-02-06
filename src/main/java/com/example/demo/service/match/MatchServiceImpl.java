package com.example.demo.service.match;

import com.example.demo.model.Match;
import com.example.demo.repo.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MatchServiceImpl implements MatchService {
    @Autowired
    private MatchRepository matchRepository;

    @Override
    public Match findMatchById(Integer id) {
        return matchRepository.findMatchById(id);
    }

    @Override
    public Match findMatchByDate(String date) {
        return matchRepository.findMatchByDate(date);
    }

    @Override
    public void save(Match match) {
        matchRepository.save(match);
    }

}
