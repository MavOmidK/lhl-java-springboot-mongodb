package com.oforsyth.lhl.manager;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ManagerRepository extends MongoRepository<Manager, String> {

    
    public Manager findByTeamId(String teamId);
}
