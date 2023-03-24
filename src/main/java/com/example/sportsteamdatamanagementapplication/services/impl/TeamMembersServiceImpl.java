package com.example.sportsteamdatamanagementapplication.services.impl;

import com.example.sportsteamdatamanagementapplication.exceptions.NoTeamMembers;
import com.example.sportsteamdatamanagementapplication.model.Team;
import com.example.sportsteamdatamanagementapplication.model.TeamMembers;
import com.example.sportsteamdatamanagementapplication.services.TeamMembersService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class TeamMembersServiceImpl implements TeamMembersService {
    private static final Map<Integer, TeamMembers> teamMembersMap = new HashMap<>();
    public static int id = 0;

    @Override
    public long addTeamMembers(TeamMembers teamMembers, int idTeam) {
        for (Map.Entry<Integer, Team> entry : TeamServiceImpl.getTeamMap().entrySet()) {
            Team team = entry.getValue();
            if (TeamServiceImpl.getTeamMap().containsKey(idTeam)) {
                team.getTeamMembers().add(teamMembers);
                teamMembersMap.put(id, teamMembers);
            } else {
                throw new NoTeamMembers("Команды по такому id нет!");
            }
        }
        return id++;
    }

    @Override
    public TeamMembers editTeamMembers(int id, TeamMembers teamMembers) {
        if (teamMembersMap.containsKey(id)) {
            teamMembersMap.put(id, teamMembers);
            return teamMembers;
        }
        throw new NoTeamMembers("Участников каких либо сортивных команд нет!");
    }

    @Override
    public boolean deleteTeamMembers(int id) {
        if (teamMembersMap.containsKey(id)) {
            teamMembersMap.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Collection<TeamMembers> getTeamMembers() {
        return teamMembersMap.values();
    }

    public static Map<Integer, TeamMembers> getTeamMembersMap() {
        return teamMembersMap;
    }

    public static void addTeamMembers1(TeamMembers teamMembers) {
        teamMembersMap.put(id, teamMembers);
        id++;
    }
}

