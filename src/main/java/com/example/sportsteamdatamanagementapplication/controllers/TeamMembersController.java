package com.example.sportsteamdatamanagementapplication.controllers;

import com.example.sportsteamdatamanagementapplication.model.TeamMembers;
import com.example.sportsteamdatamanagementapplication.services.TeamMembersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/TeamMembers")
@RequiredArgsConstructor
@Tag(name = "Управление участниками спортивных команд")
public class TeamMembersController {

    private final TeamMembersService teamMembersService;

    @PostMapping("/{id}")
    @Operation(
            summary = "Endpoint для добаления участников спортивных команд")
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
    public ResponseEntity<Long> addTeamMembers(@RequestBody TeamMembers teamMembers, @PathVariable int id) {
        long id1 = teamMembersService.addTeamMembers(teamMembers, id);
        return ResponseEntity.ok(id1);
    }

    @PutMapping("/{id},{idTeam}")
    @Operation(
            summary = "Endpoint для измениния данных участников спортивных команд по id")
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
    public ResponseEntity<TeamMembers> editTeamMembers(@PathVariable int id, @PathVariable int idTeam,
                                                       @RequestBody TeamMembers teamMembers) {
        TeamMembers teamMembers1 = teamMembersService.editTeamMembers(id, idTeam, teamMembers);
        if (teamMembers1 == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(teamMembers);
    }

    @DeleteMapping("/{id}, {idTeam}")
    @Operation(
            summary = "Endpoint для удаления участников спортивных команд по id")
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
    public ResponseEntity<Void> deleteTeamMembers(@PathVariable int id, @PathVariable int idTeam) {
        if (teamMembersService.deleteTeamMembers(id, idTeam)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    @Operation(
            summary = "Endpoint для получения всех участников спортивных команд")
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
    public ResponseEntity<Collection<TeamMembers>> getAllTeamMembers() {
        if (teamMembersService.getTeamMembers().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(teamMembersService.getTeamMembers());
    }

    @PutMapping("/transfer/{idTeam},{idMembers},{idTeam2}")
    @Operation(
            summary = "Endpoint для перевода участников спортивных команд в другие команды по id и данным участника")
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
    public ResponseEntity<String> transferParticipant(@PathVariable int idTeam,@PathVariable int idMembers,@PathVariable int idTeam2,
                                                      @RequestParam(required = false, name = "Введите данные участника команды, которого переводят")TeamMembers teamMembers) {
        String s = teamMembersService.transferParticipant(idTeam,idMembers, idTeam2, teamMembers);
        if (s == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Участник успешно переведен в другую команду!");
    }
}
