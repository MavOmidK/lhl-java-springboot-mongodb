package com.oforsyth.lhl.manager;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "managers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager {
    @Id
    private String id;
    private String teamId;
    private String fullName;
    private Boolean active;
}
