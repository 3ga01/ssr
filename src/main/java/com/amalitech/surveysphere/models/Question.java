package com.amalitech.surveysphere.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    private String id;

    private String content;

    private String tag;

    @DBRef
    private List<Response> responses;

    private String[] answers;

    private Survey survey;
}
