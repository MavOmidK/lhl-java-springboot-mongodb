package com.oforsyth.lhl.player;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.oforsyth.lhl.player.model.PlayerStatus;
import com.oforsyth.lhl.player.model.PlayerPosition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Document(collection = "players")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    public static final int PROSPECT_THRESHOLD_GAMES = 81; // This static field will not be affected by @Data

    @Id
    private String id;
    private String teamId;
    private String firstName;
    private String lastName;
    private PlayerPosition playerPosition;
    private PlayerStatus playerStatus;
    private Boolean isProspect;
    private int gamesPlayed;
}   
