package com.sut.ood.onlinefoodbackend.Contoller.Configiration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

                http
                .csrf().disable()
                .headers().frameOptions().disable().and()
                .authorizeHttpRequests()
                .anyRequest().permitAll()
                .and()
                .httpBasic();
        return http.build();

        //When Connecting to Frontend

//        http
//                .cors().and()
//                .csrf().disable()
//                .headers().frameOptions().disable().and()
//                .authorizeHttpRequests()
//                .anyRequest().permitAll()
//                .and()
//                .httpBasic();
//        return http.build();
    }
}