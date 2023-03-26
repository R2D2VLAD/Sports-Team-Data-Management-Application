package com.example.sportsteamdatamanagementapplication.repository;

import com.example.sportsteamdatamanagementapplication.model.TeamMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMembersRepository extends JpaRepository<TeamMembers, Integer> {
}
