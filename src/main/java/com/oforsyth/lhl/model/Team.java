package com.oforsyth.lhl.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "teams")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    @Id
    private String id;
    private String name;
    // private Date createdDate;
    // private String managerId;
    private Boolean active; // If the team is currently active
    private String[] activeRoster;
    private String[] prospectRoster; 
    
}
