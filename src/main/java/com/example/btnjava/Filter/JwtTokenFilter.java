package com.example.btnjava.Filter;

import com.example.btnjava.Model.Entity.UserEntity;
import com.example.btnjava.Utils.JwtTokenUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {
    private final JwtTokenUtils jwtTokenUtils;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        try{
            if(isByPassToken(request)){
                filterChain.doFilter(request, response);
                return;
            }
            final String authHeader = request.getHeader("Authorization");
            if(authHeader == null || !authHeader.startsWith("Bearer ")){
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
                return;
            }
            final String token = authHeader.substring(7);
            final String userName = jwtTokenUtils.extractUsername(token);
            if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null){
                UserEntity userEntity = (UserEntity) userDetailsService.loadUserByUsername(userName);
                if(jwtTokenUtils.isValidateToken(token, userEntity)){
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userEntity
                            , null
                            , userEntity.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
            filterChain.doFilter(request, response);
        }catch(Exception e){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        }
    }

    public boolean isByPassToken(@NonNull HttpServletRequest request) {
        final List<Pair<String, String>> list = Arrays.asList(
                Pair.of("/users/login", "POST"),
                Pair.of("/users/register", "POST"),
                Pair.of("/login", "GET"),
                Pair.of("/register", "GET")
//                Pair.of("/static/**", "GET"),
//                Pair.of("/css/**", "GET"),
//                Pair.of("/img/**", "GET"),
//                Pair.of("/js/**", "GET"),
//                Pair.of("/lib/**", "GET"),
//                Pair.of("/scss/**", "GET")

        );
        for(Pair<String, String> pair : list) {
            if(request.getServletPath().contains(pair.getFirst()) &&
                 request.getMethod().equals(pair.getSecond())) {
                return true;
            }
        }
        return false;
    }
}
