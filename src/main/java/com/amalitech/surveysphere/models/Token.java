package com.amalitech.surveysphere.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Token {

    private  String token;

    private Boolean isTokenExpired;

    private User userId;
}
