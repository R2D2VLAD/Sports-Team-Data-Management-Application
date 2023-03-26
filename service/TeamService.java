package com.example.sportsteamdatamanagementapp.service;

import com.example.sportsteamdatamanagementapp.model.PositionOfTeam;
import com.example.sportsteamdatamanagementapp.model.SportType;
import com.example.sportsteamdatamanagementapp.model.Team;
import com.example.sportsteamdatamanagementapp.model.TeamMembers;

import java.util.List;

public interface TeamService {

    long addTeam(Team team);

    Team editTeam(int id, Team team);

    boolean deleteTeam(int id);

    List<Team> getAllTeam(SportType sportType, Integer dataMin, Integer dataMax);


    List<TeamMembers> getAllTeamMembersTeam(PositionOfTeam positionOfTeam, int id);
}
