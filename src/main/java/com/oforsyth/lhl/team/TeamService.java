package com.oforsyth.lhl.team;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    /*
     * Create a new team.
     */
    public Team createTeam(Team team) {
        team.setId(UUID.randomUUID().toString().split("-")[0]);
        return teamRepository.save(team);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }
    
    public Optional<Team> getTeamById(String id) {
        return teamRepository.findById(id);
    }

    public Team getTeamByName(String name) {
        return teamRepository.findByName(name);
    }

    public Team updateTeam(Team teamRequest) {
        System.out.println(teamRequest);
        Team existingTeam = teamRepository.findById(teamRequest.getId()).get();
        existingTeam.setName(teamRequest.getName());
        existingTeam.setManagerId(teamRequest.getManagerId());
        existingTeam.setActiveRoster(teamRequest.getActiveRoster());
        existingTeam.setProspectRoster(teamRequest.getProspectRoster());
        return teamRepository.save(existingTeam);
    }

    public String deleteTeam(String id) {
        teamRepository.deleteById(id);
        return "Team with ID: " + id + " has been deleted.";
    }
}
