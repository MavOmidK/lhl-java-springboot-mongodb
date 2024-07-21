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

    // CRUD methods for Team objects

    /*
     * Create a new team.
     */
    public Team createTeam(Team team) {
        team.setId(UUID.randomUUID().toString());
        return teamRepository.save(team);
    }
    /*
     * Get all teams.
     */
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }
    
    /*
    * Get a team by its ID.
    */
    public Optional<Team> getTeamById(String id) {
        return teamRepository.findById(id);
    }

    /*
     * Get a team by its name.
     */
    public Team getTeamByName(String name) {
        return teamRepository.findByName(name);
    }

    /*
     * 
     */
    public List<Team> getTeamsByActiveStatus(boolean activeStatus) {
        return teamRepository.getTeamsByActiveStatus(activeStatus);
    }

    /*
     * Update a team.
     */
    public Team updateTeam(Team teamRequest) {
        // Get the existing team
        Team existingTeam = teamRepository.findById(teamRequest.getId()).get();
        // Populate new value from request to existing object/entity/document. Think of using a object mapping library like MapStruct.
        existingTeam.setName(teamRequest.getName());
        existingTeam.setActive(teamRequest.getActive());
        existingTeam.setActiveRoster(teamRequest.getActiveRoster());
        existingTeam.setProspectRoster(teamRequest.getProspectRoster());
        // Return the same object, not teamRequest because we never want to change certain properties like ID.
        return teamRepository.save(existingTeam);
    }

    /*
     * Delete a team by its ID.

     */
    public String deleteTeam(String id) {
        teamRepository.deleteById(id);
        return "Team with ID: " + id + " has been deleted.";
    }
}
