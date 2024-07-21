package com.oforsyth.lhl.player;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oforsyth.lhl.player.model.Goalie;
import com.oforsyth.lhl.player.model.Skater;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Skater createSkater(Skater skater) {
        skater.setId(UUID.randomUUID().toString());
        return playerRepository.save(skater);
    }

    public Goalie createGoalie(Goalie goalie) {
        goalie.setId(UUID.randomUUID().toString());
        return playerRepository.save(goalie);
    }

    // TODO: This is requiring a Optional for some reason. Find out why? 
    public Optional<Player> getPlayerById(String id) {
        return playerRepository.findById(id);
    }

    public List<Player> getPlayedByTeamId(String teamId) {
        return playerRepository.findByTeamId(teamId);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Skater updateSkater(Skater skaterRequest) {
        Skater existingSkater = (Skater) playerRepository.findById(skaterRequest.getId()).get();
        existingSkater.setPlayerPosition(skaterRequest.getPlayerPosition());
        existingSkater.setPlayerStatus(skaterRequest.getPlayerStatus());
        existingSkater.setIsProspect(skaterRequest.getIsProspect());
        existingSkater.setGamesPlayed(skaterRequest.getGamesPlayed());
        existingSkater.setGoals(skaterRequest.getGoals());
        existingSkater.setAssists(skaterRequest.getAssists());
        return this.playerRepository.save(existingSkater);
    }

    public Goalie updateGoalie(Goalie goalieRequest) {
        Goalie existingGoalie = (Goalie) playerRepository.findById(goalieRequest.getId()).get();
        existingGoalie.setPlayerPosition(goalieRequest.getPlayerPosition());
        existingGoalie.setPlayerStatus(goalieRequest.getPlayerStatus());
        existingGoalie.setIsProspect(goalieRequest.getIsProspect());
        existingGoalie.setGamesPlayed(goalieRequest.getGamesPlayed());
        existingGoalie.setWins(goalieRequest.getWins());
        existingGoalie.setLosses(goalieRequest.getLosses());
        existingGoalie.setShutouts(goalieRequest.getShutouts());
        return this.playerRepository.save(existingGoalie);
    }

    public String deletePlayer(String id) {
        playerRepository.deleteById(id);
        return "Player with ID: " + id + " has been deleted.";
    }
}
