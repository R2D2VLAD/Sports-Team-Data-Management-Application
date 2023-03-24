package com.example.sportsteamdatamanagementapplication.model;


import com.example.sportsteamdatamanagementapplication.exceptions.NoDataAvailable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "Sports_teams_members", schema = "public", catalog = "postgres")
@EqualsAndHashCode
public class TeamMembers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JsonIgnore
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_team", nullable = false)
    @JsonIgnore
    private Team teamId;
    @Basic
    @Column(name = "lastname", nullable = false, length = 50)
    private String surname;
    @Basic
    @Column(name = "firstname", nullable = false, length = 50)
    private String name;
    @Basic
    @Column(name = "patronymic", nullable = false, length = 50)
    private String patronymic;
    @Basic
    @Column(name = "yearsOfBirth", nullable = false)
    private Integer yearsOfBirth;
    @Basic
    @Column(name = "positionTeam", nullable = false, length = 50)
    private PositionOfTeam positionOfTeam;

    public TeamMembers() {
    }

    public TeamMembers(String surname, String name, String patronymic, Integer yearsOfBirth, PositionOfTeam positionOfTeam) {
        this.surname = validationCheckSurname(surname);
        this.name = validationCheckName(name);
        this.patronymic = validationCheckPatronymic(patronymic);
        this.yearsOfBirth = yearsOfBirth;
        this.positionOfTeam = positionOfTeam;
    }

    private String validationCheckSurname(String surname) {
        if (surname != null && !surname.isBlank() && !surname.isEmpty()) {
            return surname;
        }
        throw new NoDataAvailable("Поле surname заполнено некорректно!");
    }

    private String validationCheckName(String name) {
        if (name != null && !name.isBlank() && !name.isEmpty()) {
            return name;
        }
        throw new NoDataAvailable("Поле name заполнено некорректно!");
    }

    private String validationCheckPatronymic(String patronymic) {
        if (patronymic != null && !patronymic.isBlank() && !patronymic.isEmpty()) {
            return patronymic;
        }
        throw new NoDataAvailable("Поле patronymic заполнено некорректно!");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Integer getYearsOfBirth() {
        return yearsOfBirth;
    }

    public void setYearsOfBirth(Integer dateOfBirth) {
        this.yearsOfBirth = dateOfBirth;
    }

    public PositionOfTeam getPositionOfTeam() {
        return positionOfTeam;
    }

    public void setPositionOfTeam(PositionOfTeam positionOfTeam) {
        this.positionOfTeam = positionOfTeam;
    }

    public Team getTeamId() {
        return teamId;
    }

    public void setTeamId(Team teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return "TeamMembers{" +
                "id=" + id +
                ", teamId=" + teamId +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateOfBirth=" + yearsOfBirth +
                ", positionOfTeam=" + positionOfTeam +
                '}';
    }
}
