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
@Document(collection = "survey")
public class Survey {


    @Id
    private String id;

    private String title;

    private String category;

    private String userId;

    @DBRef
    private List<Question> questions;


}
