package com.example.sportsteamdatamanagementapp.repository;

import com.example.sportsteamdatamanagementapp.model.TeamMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMembersRepository extends JpaRepository<TeamMembers, Integer> {
}