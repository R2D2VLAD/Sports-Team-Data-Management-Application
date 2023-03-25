package com.example.sportsteamdatamanagementapplication.services.impl;

import com.example.sportsteamdatamanagementapplication.exceptions.NoTeam;
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
                throw new NoTeam("Команды по такому id нет!");
            }
        }
        return id++;
    }

    @Override
    public String transferParticipant(int idTeam, int idMembers, int idTeam2, TeamMembers teamMembers) {
        for (Map.Entry<Integer, Team> entry : TeamServiceImpl.getTeamMap().entrySet()) {
            Team team = entry.getValue();
            if (TeamServiceImpl.getTeamMap().containsKey(idTeam)
                    && teamMembersMap.containsKey(idMembers)) {
                team.getTeamMembers().remove(idMembers);
                //teamMembersMap.remove(idMembers);
            } else {
                throw new NoTeam("Команды или ее участника по такому id нет!");
            }
            if (TeamServiceImpl.getTeamMap().containsKey(idTeam2)) {
                team.getTeamMembers().add(teamMembers);
                //teamMembersMap.put(id, teamMembers);
            } else {
                throw new NoTeam("Команды по такому названию нет!");
            }
        }
        return "Участник команды успешно переведен в другую команду";
    }

    @Override
    public TeamMembers editTeamMembers(int idTeam, int id, TeamMembers teamMembers) {
        for (Map.Entry<Integer, Team> entry : TeamServiceImpl.getTeamMap().entrySet()) {
            Team team = entry.getValue();
            if (TeamServiceImpl.getTeamMap().containsKey(idTeam)) {
                team.getTeamMembers().set(id, teamMembers);
                teamMembersMap.put(id, teamMembers);
            } else {
                throw new NoTeam("Команды по такому id нет!");
            }
        }
        return teamMembers;
    }

    @Override
    public boolean deleteTeamMembers(int id, int idTeam) {
        for (Map.Entry<Integer, Team> entry : TeamServiceImpl.getTeamMap().entrySet()) {
            Team team = entry.getValue();
            if (TeamServiceImpl.getTeamMap().containsKey(idTeam)) {
                team.getTeamMembers().remove(id);
                teamMembersMap.remove(id);
                return true;
            }
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

    public static boolean deleteTeamMembers1(int id) {
        if (teamMembersMap.containsKey(id)) {
            teamMembersMap.remove(id);
            return true;
        }
        return false;
    }
}

