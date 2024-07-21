package com.oforsyth.lhl.player;

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

import com.oforsyth.lhl.player.model.Goalie;
import com.oforsyth.lhl.player.model.Skater;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/skater")
    @ResponseStatus(HttpStatus.CREATED)
    public Skater createSkater(@RequestBody Skater skater) {
        return playerService.createSkater(skater);
    }

    @PostMapping("/goalie")
    @ResponseStatus(HttpStatus.CREATED)
    public Goalie createGoalie(@RequestBody Goalie goalie) {
        return playerService.createGoalie(goalie);
    }

    @GetMapping("/id/{id}")
    public Player getPlayerById(@PathVariable String id) {
        return playerService.getPlayerById(id).orElse(null);
    }

    @GetMapping("/team/{teamId}")
    public List<Player> getPlayersByTeamId(@PathVariable String teamId) {
        return playerService.getPlayedByTeamId(teamId);
    }

    // TODO: Figure out how to pass variables to request 
    @GetMapping()
    public List<Player> getPlayers() {
        return playerService.getAllPlayers();
    }

    @PutMapping("/skater")
    public Skater modifySkater(@RequestBody Skater skater) {
        return playerService.updateSkater(skater);
    }

    @PutMapping("/goalie")
    public Goalie modifyGoalie(@RequestBody Goalie goalie) {
        return playerService.updateGoalie(goalie);
    }

    @DeleteMapping("/{id}")
    public String deletePlayer(@PathVariable String id) {
        return playerService.deletePlayer(id);
    }
}