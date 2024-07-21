package com.oforsyth.lhl.player.model;

import com.oforsyth.lhl.player.Player;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Goalie extends Player {
    private int wins;
    private int losses;
    private int shutouts;
}