package com.learningrestapi.LearningRESTApi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddStudentRequestDto {
    @NotBlank(message = "Name is Required")
    private String name;

    @Email
    @NotBlank(message = "Email is Required")
    private String email;
}

