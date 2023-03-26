package com.example.sportsteamdatamanagementapplication.services.impl;


import com.example.sportsteamdatamanagementapplication.model.TeamMembers;
import com.example.sportsteamdatamanagementapplication.repository.TeamMembersRepository;
import com.example.sportsteamdatamanagementapplication.repository.TeamRepository;
import com.example.sportsteamdatamanagementapplication.services.TeamMembersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamMembersServiceImpl implements TeamMembersService {

    private final TeamMembersRepository teamMembersRepository;
    private final TeamRepository teamRepository;

    @Override
    public long addTeamMembers(TeamMembers teamMembers, int idTeam) {
        teamMembers.setTeamId(teamRepository.findById(idTeam).orElse(null));
        TeamMembers savedTeamMembers = teamMembersRepository.save(teamMembers);
        return savedTeamMembers.getId();
    }

    @Override
    public String transferParticipant(int idTeam, int idMembers, int idTeam2, TeamMembers teamMembers) {
        Optional<TeamMembers> optionalTeamMembers = teamMembersRepository.findById(idMembers);
        if (optionalTeamMembers.isPresent()) {
            TeamMembers currentTeamMembers = optionalTeamMembers.get();
            currentTeamMembers.setTeamId(teamRepository.findById(idTeam2).orElse(null));
            teamMembersRepository.save(currentTeamMembers);
            return "Участник успешно переведен в другую команду!";
        }
        return null;
    }

    @Override
    public TeamMembers editTeamMembers(int idTeam, int id, TeamMembers teamMembers) {
        Optional<TeamMembers> optionalTeamMembers = teamMembersRepository.findById(id);
        if (optionalTeamMembers.isPresent()) {
            TeamMembers currentTeamMembers = optionalTeamMembers.get();
            currentTeamMembers.setName(teamMembers.getName());
            currentTeamMembers.setSurname(teamMembers.getSurname());
            currentTeamMembers.setPositionOfTeam(teamMembers.getPositionOfTeam());
            currentTeamMembers.setTeamId(teamRepository.findById(idTeam).orElse(null));
            return teamMembersRepository.save(currentTeamMembers);
        }
        return null;
    }

    @Override
    public boolean deleteTeamMembers(int id, int idTeam) {
        Optional<TeamMembers> optionalTeamMembers = teamMembersRepository.findById(id);
        if (optionalTeamMembers.isPresent()) {
            teamMembersRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Collection<TeamMembers> getTeamMembers() {
        return teamMembersRepository.findAll();
    }
}

