package com.learningrestapi.LearningRESTApi.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**", "/auth/**").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/doctors/**").hasAnyRole("DOCTOR","ADMIN")
                );
//                .formLogin(Customizer.withDefaults());
        return httpSecurity.build();
    }

//    @Bean
//    UserDetailsService userDetailsService(){
//         UserDetails user1 = User.withUsername("admin")
//                 .password(passwordEncoder.encode("adminPass"))
//                 .roles("ADMIN")
//                 .build();
//
//         UserDetails user2 = User.withUsername("patient")
//                 .password(passwordEncoder.encode("patientPass"))
//                 .roles("PATIENT")
//                 .build();
//
//         return new InMemoryUserDetailsManager(user1,user2);
//    }
}
