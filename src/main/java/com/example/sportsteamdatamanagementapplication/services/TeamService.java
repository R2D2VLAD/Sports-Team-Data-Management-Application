package com.example.sportsteamdatamanagementapplication.services;


import com.example.sportsteamdatamanagementapplication.model.PositionOfTeam;
import com.example.sportsteamdatamanagementapplication.model.SportType;
import com.example.sportsteamdatamanagementapplication.model.Team;
import com.example.sportsteamdatamanagementapplication.model.TeamMembers;

import java.util.List;

public interface TeamService {

    long addTeam(Team team);

    Team editTeam(int id, Team team);

    boolean deleteTeam(int id);

    List<Team> getAllTeam(SportType sportType, Integer dataMin, Integer dataMax);

    List<TeamMembers> getAllTeamMembersTeam(PositionOfTeam positionOfTeam, Integer id);
}
