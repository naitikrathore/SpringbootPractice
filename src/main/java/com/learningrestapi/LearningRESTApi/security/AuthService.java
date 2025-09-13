package com.learningrestapi.LearningRESTApi.security;

import com.learningrestapi.LearningRESTApi.dto.LoginRequestDto;
import com.learningrestapi.LearningRESTApi.dto.LoginResponseDto;
import com.learningrestapi.LearningRESTApi.dto.SignupRequestDto;
import com.learningrestapi.LearningRESTApi.dto.SignupResponseDto;
import com.learningrestapi.LearningRESTApi.entity.CustomUser;
import com.learningrestapi.LearningRESTApi.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(),loginRequestDto.getPassword())
        );

        CustomUser user = (CustomUser) authentication.getPrincipal();

        String token = authUtil.generateAccessToken(user);

        return new LoginResponseDto(token,user.getId());
    }


    public SignupResponseDto singup(SignupRequestDto signupRequestDto) {
        CustomUser user = userRepository.findByUsername(signupRequestDto.getUsername()).orElse(null);

        if(user != null) throw new IllegalArgumentException("User Already Exists");

        user = userRepository.save(CustomUser.builder()
                .username(signupRequestDto.getUsername())
                .password(passwordEncoder.encode(signupRequestDto.getPassword()))
                .build()
        );

        return new SignupResponseDto(user.getId(),user.getUsername());
    }
}
