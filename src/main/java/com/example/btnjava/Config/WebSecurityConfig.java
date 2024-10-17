package com.example.btnjava.Config;

import com.example.btnjava.Filter.JwtTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
    private final JwtTokenFilter jwtTokenFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf((AbstractHttpConfigurer::disable))
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(request -> {
                    request
                            .requestMatchers("/api/users/login","/api/users/register","/login")
                            .permitAll()
                            .requestMatchers(GET,
                                    "/api/admin/**").hasRole("ADMIN")
                            .requestMatchers(GET,
                                    "/api/users/search").hasRole("USER")
                            .requestMatchers(POST,
                                    "/api/user/create").hasRole("USER")
                            .requestMatchers(GET,
                                    "/api/users/{userName}/added-buildings").hasRole("USER")
                            .anyRequest().authenticated();
                });
        return http.build();
    }
}
