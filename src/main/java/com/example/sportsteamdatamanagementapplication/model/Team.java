package com.example.sportsteamdatamanagementapplication.model;


import com.example.sportsteamdatamanagementapplication.exceptions.NoDataAvailable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Team")
@EqualsAndHashCode
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;
    @Column(name = "teamName")
    private String nameMembers;
    private SportType sportType;
    private Integer yearsOfFoundation;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeamMembers> teamMembers;

    public Team() {
    }

    public Team(String nameMembers, SportType sportType, Integer dateOfFoundation) {
        this.nameMembers = validationCheckNameMembers(nameMembers);
        this.sportType = sportType;
        this.yearsOfFoundation = dateOfFoundation;
        teamMembers = new ArrayList<>();
    }

    private String validationCheckNameMembers(String nameMembers) {
        if (nameMembers != null && !nameMembers.isBlank() && !nameMembers.isEmpty()) {
            return nameMembers;
        }
        throw new NoDataAvailable("Поле name заполнено некорректно!");
    }

    public String getNameMembers() {
        return nameMembers;
    }

    public void setNameMembers(String nameMembers) {
        this.nameMembers = nameMembers;
    }

    public SportType getSportType() {
        return sportType;
    }

    public void setSportType(SportType sportType) {
        this.sportType = sportType;
    }

    public Integer getYearsOfFoundation() {
        return yearsOfFoundation;
    }

    public void setYearsOfFoundation(int dateOfFoundation) {
        this.yearsOfFoundation = dateOfFoundation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<TeamMembers> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<TeamMembers> teamMembers) {
        this.teamMembers = teamMembers;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", nameMembers='" + nameMembers + '\'' +
                ", sportType=" + sportType +
                ", yearsOfFoundation=" + yearsOfFoundation +
                ", teamMembers=" + teamMembers +
                '}';
    }
}
