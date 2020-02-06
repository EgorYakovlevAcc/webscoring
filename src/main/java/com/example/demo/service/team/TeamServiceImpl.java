package com.example.demo.service.team;

import com.example.demo.model.Team;
import com.example.demo.repo.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Team findTeamById(Integer id) {
        return teamRepository.findTeamById(id);
    }

    @Override
    public Team findTeamByName(String name) {
        return teamRepository.findTeamByName(name);
    }

    @Override
    public void save(Team team) {
        teamRepository.save(team);
    }
}
