package com.oforsyth.lhl.team;

import java.util.Date;

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
    private Date createdDate;
    private String[] activeRoster;
    private String[] prospectRoster; 
}
