package com.oforsyth.lhl.team;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface TeamRepository extends MongoRepository<Team, String> {

    Team findByName(String name);

    @Query("{active: ?0}")
    List<Team> getTeamsByActiveStatus(boolean activeStatus);
}
