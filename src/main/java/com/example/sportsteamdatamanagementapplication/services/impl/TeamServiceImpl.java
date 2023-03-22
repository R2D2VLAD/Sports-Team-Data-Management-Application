package com.example.sportsteamdatamanagementapplication.services.impl;

import com.example.sportsteamdatamanagementapplication.dao.TeamDao;
import com.example.sportsteamdatamanagementapplication.model.Team;
import com.example.sportsteamdatamanagementapplication.services.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private TeamDao teamDao;

    public TeamServiceImpl(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    public TeamServiceImpl() {
    }

    @Override
    public List<Team> findAllTeam() {
        return teamDao.findAllTeam();
    }

    @Override
    public void addTeam(Team team) {
        teamDao.addTeam(team);
    }

    @Override
    public void deleteTeam(Team team) {
        teamDao.deleteTeam(team);
    }

    @Override
    public void updateTeam(Team team) {
        teamDao.updateTeam(team);
    }

}
