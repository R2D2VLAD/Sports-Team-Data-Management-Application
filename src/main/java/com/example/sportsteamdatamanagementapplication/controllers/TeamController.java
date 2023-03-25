package com.example.sportsteamdatamanagementapplication.controllers;


import com.example.sportsteamdatamanagementapplication.model.PositionOfTeam;
import com.example.sportsteamdatamanagementapplication.model.SportType;
import com.example.sportsteamdatamanagementapplication.model.Team;
import com.example.sportsteamdatamanagementapplication.model.TeamMembers;
import com.example.sportsteamdatamanagementapplication.services.TeamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Team")
@RequiredArgsConstructor
@Tag(name = "Управление спортивными командами", description = "CRUD операции по управлению данными спортивных команд")
public class TeamController {

    private final TeamService teamService;
    @PostMapping
    @Operation(
            summary = "Endpoint для добаления спортивных команд")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Всё хорошо, запрос выполнился!",
                    content = {
                            @Content(mediaType = "application/json")}),
            @ApiResponse(
                    responseCode = "400",
                    description = "Есть ошибка в параметрах запроса",
                    content = {
                            @Content(mediaType = "application/json")}),
            @ApiResponse(
                    responseCode = "404",
                    description = "URL неверный или такого действия в приложении нет!",
                    content = {
                            @Content(mediaType = "application/json")}),
            @ApiResponse(
                    responseCode = "500",
                    description = "Во время выполнения запроса произошла ошибка на сервере!",
                    content = {
                            @Content(mediaType = "application/json")}),})
    public ResponseEntity<Long> addTeam(@RequestBody Team team) {
        long id = teamService.addTeam(team);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Endpoint для измениния данных спортивных команд по id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Всё хорошо, запрос выполнился!",
                    content = {
                            @Content(mediaType = "application/json")}),
            @ApiResponse(
                    responseCode = "400",
                    description = "Есть ошибка в параметрах запроса",
                    content = {
                            @Content(mediaType = "application/json")}),
            @ApiResponse(
                    responseCode = "404",
                    description = "URL неверный или такого действия в приложении нет!",
                    content = {
                            @Content(mediaType = "application/json")}),
            @ApiResponse(
                    responseCode = "500",
                    description = "Во время выполнения запроса произошла ошибка на сервере!",
                    content = {
                            @Content(mediaType = "application/json")}),})
    public ResponseEntity<Team> editTeam(@PathVariable int id, @RequestBody Team team) {
        Team team1 = teamService.editTeam(id, team);
        if (team1 == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(team);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Endpoint для удаления спортивных команд по id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Всё хорошо, запрос выполнился!",
                    content = {
                            @Content(mediaType = "application/json")}),
            @ApiResponse(
                    responseCode = "400",
                    description = "Есть ошибка в параметрах запроса",
                    content = {
                            @Content(mediaType = "application/json")}),
            @ApiResponse(
                    responseCode = "404",
                    description = "URL неверный или такого действия в приложении нет!",
                    content = {
                            @Content(mediaType = "application/json")}),
            @ApiResponse(
                    responseCode = "500",
                    description = "Во время выполнения запроса произошла ошибка на сервере!",
                    content = {
                            @Content(mediaType = "application/json")}),})
    public ResponseEntity<Void> deleteTeam(@PathVariable int id) {
        if (teamService.deleteTeam(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    @Operation(
            summary = "Endpoint получения всех спортивных команд по определенным настройкам")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Всё хорошо, запрос выполнился!",
                    content = {
                            @Content(mediaType = "application/json")}),
            @ApiResponse(
                    responseCode = "400",
                    description = "Есть ошибка в параметрах запроса",
                    content = {
                            @Content(mediaType = "application/json")}),
            @ApiResponse(
                    responseCode = "404",
                    description = "URL неверный или такого действия в приложении нет!",
                    content = {
                            @Content(mediaType = "application/json")}),
            @ApiResponse(
                    responseCode = "500",
                    description = "Во время выполнения запроса произошла ошибка на сервере!",
                    content = {
                            @Content(mediaType = "application/json")}),})
    public ResponseEntity<List<Team>> getAllTeam(@RequestParam(required = false, name = "Вид спорта")SportType sportType,
                                           @RequestParam(required = false, name = "Год с которой начнется поиск всех команд(гггг)") Integer dataMin,
                                           @RequestParam(required = false, name = "Год до которой будет произведен поиск всех команд(гггг)") Integer dataMax) {
        List<Team> team = teamService.getAllTeam(sportType, dataMin, dataMax);
        if (team == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(team);
    }
    @GetMapping("/{id}")
    @Operation(
            summary = "Endpoint для получения участников конкретных спортивных команд по определенным настройкам")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Всё хорошо, запрос выполнился!",
                    content = {
                            @Content(mediaType = "application/json")}),
            @ApiResponse(
                    responseCode = "400",
                    description = "Есть ошибка в параметрах запроса",
                    content = {
                            @Content(mediaType = "application/json")}),
            @ApiResponse(
                    responseCode = "404",
                    description = "URL неверный или такого действия в приложении нет!",
                    content = {
                            @Content(mediaType = "application/json")}),
            @ApiResponse(
                    responseCode = "500",
                    description = "Во время выполнения запроса произошла ошибка на сервере!",
                    content = {
                            @Content(mediaType = "application/json")}),})
    public ResponseEntity<List<TeamMembers>> getAllTeamMembersTeam(@RequestParam(required = false, name = "Позиция в команде") PositionOfTeam positionOfTeam,
                                                                   @PathVariable int id) {
        List<TeamMembers> teamMembers = teamService.getAllTeamMembersTeam(positionOfTeam, id);
        if (teamMembers == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(teamMembers);
    }
}
