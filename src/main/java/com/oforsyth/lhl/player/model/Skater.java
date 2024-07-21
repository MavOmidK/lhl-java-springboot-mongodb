package com.oforsyth.lhl.player.model;

import com.oforsyth.lhl.player.Player;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Skater extends Player {
    private int goals;
    private int assists;
    private int points;
}