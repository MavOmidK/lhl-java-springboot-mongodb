package com.oforsyth.lhl.team;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping // Mapping the post request
    @ResponseStatus(HttpStatus.CREATED)
    public Team createTeam(@RequestBody Team team) {
        return teamService.createTeam(team);
    }

    @GetMapping // No input, just fetch from the DB
     public List<Team> getTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable String id) {
        return teamService.getTeamById(id).orElse(null);
    }
    
    @GetMapping("/name/{name}")
    public Team getTeamByName(@PathVariable String name) {
        return teamService.getTeamByName(name);
    }

    @GetMapping("/active/{activeStatus}")
    public List<Team> getTeamsByActiveStatus(@PathVariable boolean activeStatus) {
        return teamService.getTeamsByActiveStatus(activeStatus);
    }

    @PutMapping
    public Team modifyTeam(@RequestBody Team team) {
        return teamService.updateTeam(team);
    }

    @DeleteMapping("/{id}")
    public String deleteTeam(@PathVariable String id) {
        return teamService.deleteTeam(id);
    }
}
