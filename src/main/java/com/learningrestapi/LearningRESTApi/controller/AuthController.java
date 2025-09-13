package com.learningrestapi.LearningRESTApi.controller;

import com.learningrestapi.LearningRESTApi.dto.LoginRequestDto;
import com.learningrestapi.LearningRESTApi.dto.LoginResponseDto;
import com.learningrestapi.LearningRESTApi.dto.SignupRequestDto;
import com.learningrestapi.LearningRESTApi.dto.SignupResponseDto;
import com.learningrestapi.LearningRESTApi.security.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody @Valid LoginRequestDto loginRequestDto){
        return ResponseEntity.ok(authService.login(loginRequestDto));
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDto> signup(@RequestBody @Valid SignupRequestDto signupRequestDto){
        return ResponseEntity.ok(authService.singup(signupRequestDto));
    }



}
