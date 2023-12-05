package com.amalitech.surveysphere.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user")
public class User {
    //Change all arays to Arrayists
    @Id
    private String id;

    private String name;

    private String username;

    private String email;

    private String password;

    private String role;

    @DBRef
    private List<Survey> surveyId;

    @DBRef
    private List<Token> tokens;
}
