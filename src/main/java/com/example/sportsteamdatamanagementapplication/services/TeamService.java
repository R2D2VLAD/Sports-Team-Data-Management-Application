package com.example.sportsteamdatamanagementapplication.services;

import com.example.sportsteamdatamanagementapplication.model.Team;

import java.util.List;

public interface TeamService {
    List<Team> findAllTeam();

    void addTeam(Team team);

    void deleteTeam(Team team);

    void updateTeam(Team team);
}
