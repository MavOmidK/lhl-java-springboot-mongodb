package com.oforsyth.lhl.team;

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
    private String managerId;
    private String[] activeRoster; // Player IDs
    private String[] prospectRoster; // Player IDs
}
