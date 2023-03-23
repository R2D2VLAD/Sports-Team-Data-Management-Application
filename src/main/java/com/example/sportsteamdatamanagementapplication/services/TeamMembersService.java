package com.example.sportsteamdatamanagementapplication.services;

import com.example.sportsteamdatamanagementapplication.model.TeamMembers;

import java.util.Collection;

public interface TeamMembersService {
    long addTeamMembers(TeamMembers teamMembers);

    TeamMembers editTeamMembers(int id, TeamMembers teamMembers);

    boolean deleteTeamMembers(int id);

    Collection<TeamMembers> getTeamMembers();
}
