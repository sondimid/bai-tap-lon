package com.example.btnjava.Filter;

import com.example.btnjava.Model.Entity.UserEntity;
import com.example.btnjava.Utils.JwtTokenUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {
    private final JwtTokenUtils jwtTokenUtils;
    private final UserDetailsService userDetailsService;
    public static final Set<String> WHITE_LIST = new HashSet<>();
    static {
        WHITE_LIST.add("/static/**");
        WHITE_LIST.add("/login");
        WHITE_LIST.add("/register");
        WHITE_LIST.add("/get-all-motels");
        WHITE_LIST.add("/search/**");
        WHITE_LIST.add("/motel/**");
        WHITE_LIST.add("/get-motels-by-user/**");
        WHITE_LIST.add("/chat/**");
        WHITE_LIST.add("/messages/**");
        WHITE_LIST.add("/forgot-password/**");
        WHITE_LIST.add("/reset-password");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try{
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

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        AntPathMatcher pathMatcher = new AntPathMatcher();
        return WHITE_LIST.stream().anyMatch(p -> pathMatcher.match(p, request.getRequestURI()));
    }

}
