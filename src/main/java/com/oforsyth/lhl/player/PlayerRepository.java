package com.oforsyth.lhl.player;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<Player, Object> {

    public List<Player> findByTeamId(String teamId);
}

