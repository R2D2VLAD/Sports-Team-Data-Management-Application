package com.example.sportsteamdatamanagementapp.service.impl;

import com.example.sportsteamdatamanagementapp.model.TeamMembers;
import com.example.sportsteamdatamanagementapp.repository.TeamMembersRepository;
import com.example.sportsteamdatamanagementapp.repository.TeamRepository;
import com.example.sportsteamdatamanagementapp.service.TeamMembersService;
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
        teamMembers.setTeam(teamRepository.findById(idTeam).orElse(null));
        TeamMembers savedTeamMembers = teamMembersRepository.save(teamMembers);
        return savedTeamMembers.getId();
    }

    @Override
    public String transferParticipant(int idTeam, int idMembers, int idTeam2, TeamMembers teamMembers) {
        Optional<TeamMembers> optionalTeamMembers = teamMembersRepository.findById(idMembers);
        if (optionalTeamMembers.isPresent()) {
            TeamMembers currentTeamMembers = optionalTeamMembers.get();
            currentTeamMembers.setTeam(teamRepository.findById(idTeam2).orElse(null));
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
            currentTeamMembers.setTeam(teamRepository.findById(idTeam).orElse(null));
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
