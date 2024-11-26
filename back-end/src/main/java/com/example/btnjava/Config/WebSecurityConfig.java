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

import static org.springframework.http.HttpMethod.*;

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
                            .requestMatchers("/static/**","/messages/**").permitAll()
                            .requestMatchers("/get-all-motels","/login","/register",
                                    "/search/**","/motel/**","/get-motels-by-user/**","/chat/**",
                                    "/forgot-password/**","/reset-password","/find-by-radius").permitAll()
                            .requestMatchers(GET,
                                    "/admin/**").hasRole("ADMIN")
                            .requestMatchers(POST,
                                    "/upload-avatar/**").hasAnyRole("USER","ADMIN")
                            .requestMatchers(GET,
                                    "/dashboard").hasRole("ADMIN")
                            .requestMatchers(POST,
                                    "/create").hasAnyRole("USER","ADMIN")
                            .requestMatchers(GET,
                                    "/my-motel").hasAnyRole("USER","ADMIN")
                            .requestMatchers(POST,
                                    "/admin/markMotel").hasRole("ADMIN")
                            .requestMatchers(GET,
                                    "/admin/list-user").hasRole("ADMIN")
                            .requestMatchers(GET,
                                    "/user/list-user").hasRole("USER")
                            .requestMatchers(GET,
                                    "/get-all-messages").hasRole("USER")
                            .requestMatchers(GET,
                                    "/get-all-ids").hasAnyRole("USER","ADMIN")
                            .requestMatchers(DELETE,
                                    "/delete-motels").hasAnyRole("USER","ADMIN")
                            .requestMatchers(DELETE,
                                    "/admin/**").hasRole("ADMIN")
                            .anyRequest().authenticated();
                })
                .authenticationProvider(authenticationProvider);


        return http.build();
    }


}
