package com.example.demo.service.team;

import com.example.demo.model.Team;

public interface TeamService {
    Team findTeamById(Integer id);
    Team findTeamByName(String name);
    void save(Team team);
}
