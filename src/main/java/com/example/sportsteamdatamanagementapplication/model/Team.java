package com.example.sportsteamdatamanagementapplication.model;


import com.example.sportsteamdatamanagementapplication.exceptions.NoDataAvailable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sports_teams")
@EqualsAndHashCode
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JsonIgnore
    private int id;
    @Basic
    @Column(name = "team_name", nullable = false, length = 50)
    private String nameMembers;
    @Basic
    @Column(name = "sport_type", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private SportType sportType;
    @Basic
    @Column(name = "years_of_foundation", nullable = false)
    private Integer yearsOfFoundation;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "teamId", cascade = CascadeType.ALL, orphanRemoval = true)
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
