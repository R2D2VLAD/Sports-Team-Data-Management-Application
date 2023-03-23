package com.example.sportsteamdatamanagementapplication.services.impl;

import com.example.sportsteamdatamanagementapplication.exceptions.NoTeamMembers;
import com.example.sportsteamdatamanagementapplication.model.TeamMembers;
import com.example.sportsteamdatamanagementapplication.services.TeamMembersService;
import com.example.sportsteamdatamanagementapplication.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class TeamMembersServiceImpl implements TeamMembersService {

    private static final Map<Integer, TeamMembers> teamMembersMap = new HashMap<>();
    public static int id = 0;

    @Override
    public long addTeamMembers(TeamMembers teamMembers) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        teamMembersMap.put(id, teamMembers);
        session.save(teamMembers);
        tx1.commit();
        session.close();
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
}

