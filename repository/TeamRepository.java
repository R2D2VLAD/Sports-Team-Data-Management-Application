package com.example.sportsteamdatamanagementapp.repository;

import com.example.sportsteamdatamanagementapp.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
}