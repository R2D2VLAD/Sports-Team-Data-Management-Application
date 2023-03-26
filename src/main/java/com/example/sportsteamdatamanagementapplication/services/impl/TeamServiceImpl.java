package com.example.sportsteamdatamanagementapplication.services.impl;

import com.example.sportsteamdatamanagementapplication.exceptions.NoTeamMembers;
import com.example.sportsteamdatamanagementapplication.model.PositionOfTeam;
import com.example.sportsteamdatamanagementapplication.model.SportType;
import com.example.sportsteamdatamanagementapplication.model.Team;
import com.example.sportsteamdatamanagementapplication.model.TeamMembers;
import com.example.sportsteamdatamanagementapplication.repository.TeamMembersRepository;
import com.example.sportsteamdatamanagementapplication.repository.TeamRepository;
import com.example.sportsteamdatamanagementapplication.services.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final TeamMembersRepository teamMembersRepository;

    @Override
    public long addTeam(Team team) {
        Team savedTeam = teamRepository.save(team);
        team.getTeamMembers().forEach(teamMembersRepository::save);
        return savedTeam.getId();
    }

    @Override
    public Team editTeam(int id, Team team) {
        team.setId(id);
        Team updatedTeam = teamRepository.save(team);
        team.getTeamMembers().forEach(teamMembersRepository::save);
        return updatedTeam;
    }

    @Override
    public boolean deleteTeam(int id) {
        if (teamRepository.existsById(id)) {
            teamRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Team> getAllTeam(SportType sportType, Integer dateMin, Integer dateMax) {
        List<Team> teamList = new ArrayList<>();
        teamRepository.findAll().forEach(team -> {
            if (team.getSportType().equals(sportType)
                    && (dateMin <= team.getYearsOfFoundation())
                    && (dateMax >= team.getYearsOfFoundation())) {
                teamList.add(team);
            } else {
                throw new NoTeamMembers("No teams!");
            }
        });
        return teamList;
    }

    @Override
    public List<TeamMembers> getAllTeamMembersTeam(PositionOfTeam positionOfTeam, Integer id) {
        List<TeamMembers> teamMembersList = new ArrayList<>();
        Optional<Team> teamOptional = teamRepository.findById(id);
        if (teamOptional.isPresent()) {
            Team team = teamOptional.get();
            for (TeamMembers teamMembers : team.getTeamMembers()) {
                if (teamMembers.getPositionOfTeam().equals(positionOfTeam)) {
                    teamMembersList.add(teamMembers);
                } else {
                    throw new NoTeamMembers("No members!");
                }
            }
        }
        return teamMembersList;
    }
}

