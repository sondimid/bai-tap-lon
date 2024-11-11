package com.example.btnjava.Config;

import com.example.btnjava.Filter.JwtTokenFilter;
import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig{
    private final JwtTokenFilter jwtTokenFilter;
    private final AuthenticationProvider authenticationProvider;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(request -> {
                    request
                            .requestMatchers("/static/**").permitAll()
                            .requestMatchers("/get-all-motels","/login","/register",
                                    "/search","/motel/**").permitAll()
                            .requestMatchers(GET,
                                    "/admin/**").hasRole("ADMIN")
                            .requestMatchers(POST,
                                    "/upload-avatar/**").hasRole("USER")
                            .requestMatchers(GET,
                                    "/dashboard").hasRole("ADMIN")
                            .requestMatchers(POST,
                                    "/create").hasRole("USER")
                            .requestMatchers(GET,
                                    "/users/{userName}/added-buildings").hasRole("USER")
                            .anyRequest().authenticated();
                })
                .authenticationProvider(authenticationProvider);


        return http.build();
    }


}
