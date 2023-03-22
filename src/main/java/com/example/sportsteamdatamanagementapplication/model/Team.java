package com.example.sportsteamdatamanagementapplication.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //Идентификатор
    @Column(name = "teamName")
    private String nameMembers; //Название команды
    private SportType sportType; //Вид спорта
    private double dateOfFoundation; //Дата основания

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeamMembers> teamMembers;

    public Team() {
    }

    public Team(String nameMembers, SportType sportType, double dateOfFoundation) {
        this.nameMembers = validationCheckNameMembers(nameMembers);
        this.sportType = sportType;
        this.dateOfFoundation = dateOfFoundation;
        teamMembers = new ArrayList<>();
    }

    private String validationCheckNameMembers(String nameMembers) {
        if (nameMembers != null && !nameMembers.isBlank() && !nameMembers.isEmpty()) {
            return nameMembers;
        }
        throw new IllegalArgumentException("Поле name заполнено некорректно!");
    }
    public void addTeamMembers(TeamMembers teamMembers1) {
        teamMembers1.setTeam(this);
        teamMembers.add(teamMembers1);
    }

    public void removeTeamMembers(TeamMembers teamMembers1) {
        teamMembers.remove(teamMembers1);
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

    public double getDateOfFoundation() {
        return dateOfFoundation;
    }

    public void setDateOfFoundation(double dateOfFoundation) {
        this.dateOfFoundation = dateOfFoundation;
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
                ", dateOfFoundation=" + dateOfFoundation +
                '}';
    }
}
