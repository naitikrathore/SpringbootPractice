package com.learningrestapi.LearningRESTApi.dto;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String Username;
    private String Password;
}
