package com.example.sportsteamdatamanagementapplication.dao;

import com.example.sportsteamdatamanagementapplication.model.Team;

import java.util.List;

public interface TeamDao {
    List<Team> findAllTeam();

    void addTeam(Team team);

    void updateTeam(Team team);

    void deleteTeam(Team team);
}
