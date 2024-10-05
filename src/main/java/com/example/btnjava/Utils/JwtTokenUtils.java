package com.example.btnjava.Utils;

import com.example.btnjava.CustomException.InvalidParamException;
import com.example.btnjava.Model.Entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class JwtTokenUtils {

    public String generateToken(UserEntity userEntity) throws Exception {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userName", userEntity.getUsername());
        try{
            return Jwts.builder()
                    .setClaims(claims)
                    .setSubject(userEntity.getUsername())
                    .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000L))
                    .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                    .compact();
        }catch (Exception e){
            throw new InvalidParamException(e.getMessage());
        }
    }
    private Key getSignInKey() {
        byte[] bytes = Decoders.BASE64.decode("TaqlmGv1iEDMRiFp/pHuID1+T84IABfuA0xXh4GhiUI=");
        return Keys.hmacShaKeyFor(bytes);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    public <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = this.extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    public boolean isTokenExpired(String token) {
        Date expiration = this.extractClaims(token, Claims::getExpiration);
        return expiration.before(new Date());
    }
    public String extractUsername(String token) {
        return extractClaims(token, Claims::getSubject);
    }
    public boolean isValidateToken(String token, UserDetails userDetails) {
        String username = extractUsername(token);
            return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }
}
