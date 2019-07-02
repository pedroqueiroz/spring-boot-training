package br.com.alura.forum.config.security;

import br.com.alura.forum.model.User;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;

import java.util.Date;

@Service
public class TokenService {

    @Value("${forum.jwt.expiration}")
    private Long expiration;

    @Value("${forum.jwt.secret}")
    private String secret;

    public String generateToken(Authentication authentication) {
        User authenticatedUser = (User) authentication.getPrincipal();
        Date today = new Date();

        return Jwts.builder()
            .setIssuer("Alura's Forum API")
            .setSubject(authenticatedUser.getId().toString())
            .setIssuedAt(today)
            .setExpiration(new Date(today.getTime() + expiration))
            .signWith(SignatureAlgorithm.HS256, secret)
            .compact();

    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
