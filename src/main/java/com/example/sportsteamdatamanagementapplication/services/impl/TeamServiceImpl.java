package com.example.sportsteamdatamanagementapplication.services.impl;

import com.example.sportsteamdatamanagementapplication.exceptions.NoTeamMembers;
import com.example.sportsteamdatamanagementapplication.model.PositionOfTeam;
import com.example.sportsteamdatamanagementapplication.model.SportType;
import com.example.sportsteamdatamanagementapplication.model.Team;
import com.example.sportsteamdatamanagementapplication.model.TeamMembers;
import com.example.sportsteamdatamanagementapplication.services.TeamMembersService;
import com.example.sportsteamdatamanagementapplication.services.TeamService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamMembersService teamMembersService;
    private static final Map<Integer, Team> teamMap = new HashMap<>();
    public static int id = 0;

    public TeamServiceImpl(TeamMembersService teamMembersService) {
        this.teamMembersService = teamMembersService;
    }

    @Override
    public long addTeam(Team team) {
        teamMap.put(id, team);
        for (TeamMembers teamMembers : team.getTeamMembers()) {
            if (!TeamMembersServiceImpl.getTeamMembersMap().containsValue(teamMembers)) {
                teamMembersService.addTeamMembers(teamMembers);
            }
        }
        return id++;
    }

    @Override
    public Team editTeam(int id, Team team) {
        if (teamMap.containsKey(id)) {
                Team team1 = teamMap.get(id);
                for (TeamMembers teamMembers : team1.getTeamMembers()){
                    if (TeamMembersServiceImpl.getTeamMembersMap().containsValue(teamMembers)) {
                        teamMembersService.deleteTeamMembers(id);
                    }
                }
                teamMap.put(id, team);
            for (TeamMembers teamMembers : team.getTeamMembers()) {
                if (!TeamMembersServiceImpl.getTeamMembersMap().containsValue(teamMembers)) {
                    teamMembersService.addTeamMembers(teamMembers);
                }
            }
        }
            return team;
    }

    @Override
    public boolean deleteTeam(int id) {
        if (teamMap.containsKey(id)) {
            Team team1 = teamMap.get(id);
            for (TeamMembers teamMembers : team1.getTeamMembers()){
                if (TeamMembersServiceImpl.getTeamMembersMap().containsValue(teamMembers)) {
                    teamMembersService.deleteTeamMembers(id);
                }
            }
            teamMap.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Team> getAllTeam(SportType sportType, Integer dataMin, Integer dataMax) {
        List<Team> teamList = new ArrayList<>();
        for (Map.Entry<Integer, Team> entry : teamMap.entrySet()) {
            Team team = entry.getValue();
            if (team.getSportType().equals(sportType)
                    && (dataMin <= team.getYearsOfFoundation())
                    && (dataMax >= team.getYearsOfFoundation())) {
                teamList.add(team);
            } else {
                throw new NoTeamMembers("No teams!");
            }
        }
        return teamList;
    }

    @Override
    public List<TeamMembers> getAllTeamMembersTeam(PositionOfTeam positionOfTeam, Integer id) {
        List<TeamMembers> teamMembersList = new ArrayList<>();
        Team team1 = teamMap.get(id);
        for (TeamMembers teamMembers : team1.getTeamMembers()) {
            if (teamMembers.getPositionOfTeam().equals(positionOfTeam)
                    && (team1.getId() == id)) {
                teamMembersList.add(teamMembers);
            } else {
                throw new NoTeamMembers("No members!");
            }
        }
        return teamMembersList;
    }
}

