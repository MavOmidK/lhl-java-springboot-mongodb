package com.oforsyth.lhl.manager;

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

@RestController
@RequestMapping("/managers")
public class ManagerController {
    
    @Autowired
    private ManagerService managerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Manager createManager(@RequestBody Manager manager) {
        return managerService.createManager(manager);
    }

    @GetMapping
    public List<Manager> getManagers() {
        return managerService.getAllManagers();
    }

    @GetMapping("/{id}")
    public Manager getManagerById(@PathVariable String id) {
        return managerService.getManagerById(id);
    }

    @PutMapping
    public Manager modifyManager(@RequestBody Manager manager) {
        return managerService.updateManager(manager);
    }

    @DeleteMapping("/{id}")
    public String deleteManager(@PathVariable String id) {
        return managerService.deleteManager(id);
    }
}
