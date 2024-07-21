package com.oforsyth.lhl.manager;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    
    @Autowired
    private ManagerRepository managerRepository;

    public Manager createManager(Manager manager) {
        manager.setId(UUID.randomUUID().toString().split("-")[0]);
        return managerRepository.save(manager);
    }

    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    public Manager getManagerById(String id) {
        return managerRepository.findById(id).get();
    }

    public Manager getManagerByTeamId(String teamId) {
        return managerRepository.findByTeamId(teamId);
    }

    public Manager updateManager(Manager managerRequest) {
        Manager existingManager = managerRepository.findById(managerRequest.getId()).get();
        existingManager.setTeamId(managerRequest.getTeamId());
        existingManager.setFullName(managerRequest.getFullName());
        existingManager.setActive(managerRequest.getActive());
        return managerRepository.save(existingManager);
    }

    public String deleteManager(String id) {
        managerRepository.deleteById(id);
        return "Manager with id " + id + " has been deleted.";
    }
}
