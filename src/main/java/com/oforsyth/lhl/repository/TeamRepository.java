package com.oforsyth.lhl.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.oforsyth.lhl.model.Team;

public interface TeamRepository extends MongoRepository<Team, String> {

    Team findByName(String name);
    
    @Query("{active: ?0}")
    List<Team> getTeamsByActiveStatus(boolean activeStatus);
}
