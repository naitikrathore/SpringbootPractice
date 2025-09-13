package com.learningrestapi.LearningRESTApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class SignupResponseDto  {
    private Long id;
    private String username;
}
