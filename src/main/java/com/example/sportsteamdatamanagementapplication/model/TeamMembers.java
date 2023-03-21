package com.example.sportsteamdatamanagementapplication.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Team_members")
public class TeamMembers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //Идентификатор игрока
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_team")
    private Team team;
    @Column(name = "lastname")
    private String surname; //Фамилия
    @Column(name = "firstname")
    private String name; //Имя
    @Column(name = "patronymic")
    private String patronymic; //Отчество
    private double dateOfBirth; //Дата рождения
    @Column(name = "positionteam")
    private PositionOfTeam positionOfTeam; //Позиция в команде

    public TeamMembers() {

    }
    public TeamMembers(String surname, String name, String patronymic, double dateOfBirth, PositionOfTeam positionOfTeam) {
        this.surname = validationCheckSurname(surname);
        this.name = validationCheckName(name);
        this.patronymic = validationCheckPatronymic(patronymic);
        this.dateOfBirth = dateOfBirth;
        this.positionOfTeam = positionOfTeam;
    }

    private String validationCheckSurname(String surname) {
        if (surname != null && !surname.isBlank() && !surname.isEmpty()) {
            return surname;
        }
        throw new IllegalArgumentException("Поле surname заполнено некорректно!");
    }

    private String validationCheckName(String name) {
        if (name != null && !name.isBlank() && !name.isEmpty()) {
            return name;
        }
        throw new IllegalArgumentException("Поле name заполнено некорректно!");
    }

    private String validationCheckPatronymic(String patronymic) {
        if (patronymic != null && !patronymic.isBlank() && !patronymic.isEmpty()) {
            return patronymic;
        }
        throw new IllegalArgumentException("Поле patronymic заполнено некорректно!");
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

    public double getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(double dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public PositionOfTeam getPositionOfTeam() {
        return positionOfTeam;
    }

    public void setPositionOfTeam(PositionOfTeam positionOfTeam) {
        this.positionOfTeam = positionOfTeam;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "TeamMembers{" +
                "id=" + id +
                ", team=" + team +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", positionOfTeam=" + positionOfTeam +
                '}';
    }
}
