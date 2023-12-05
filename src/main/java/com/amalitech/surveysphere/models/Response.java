package com.amalitech.surveysphere.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    private User userId;

    private String anonymousUserId;

    private String response;

    private Question questionId;

    private Survey survey;
}
