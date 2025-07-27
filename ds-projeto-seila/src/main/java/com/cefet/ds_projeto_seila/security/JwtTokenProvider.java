package com.cefet.ds_projeto_seila.security;

import java.util.stream.Collectors;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.cefet.ds_projeto_seila.services.AssinaturaService;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private final long jwtExpirationInMs;
    private final Key key;

    @Autowired
    private AssinaturaService assinaturaService;

    public JwtTokenProvider(@Value("${jwt.secret}") String jwtSecret,
                            @Value("${jwt.expiration}") long jwtExpirationInMs) {
        this.key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
        this.jwtExpirationInMs = jwtExpirationInMs;
    }

    public String generateToken(Authentication authentication) {
        ClienteDetails userPrincipal = (ClienteDetails) authentication.getPrincipal();

        // Obtem os roles como string
        String roles = userPrincipal.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.joining(","));

        // Verifica se o cliente tem assinatura ativa
        boolean assinaturaAtiva = assinaturaService.clienteTemAssinaturaAtiva(userPrincipal.getId());

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        return Jwts.builder()
            .setSubject(userPrincipal.getUsername())
            .claim("id", userPrincipal.getId())
            .claim("roles", roles)
            .claim("assinaturaAtiva", assinaturaAtiva) // ✅ Claim adicionada
            .setIssuedAt(now)
            .setExpiration(expiryDate)
            .signWith(this.key, SignatureAlgorithm.HS512)
            .compact();
    }

    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parserBuilder()
            .setSigningKey(this.key)
            .build()
            .parseClaimsJws(token)
            .getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(this.key).build().parseClaimsJws(authToken);
            return true;
        } catch (Exception ex) {
            System.out.println("A validação do JWT falhou: " + ex.getMessage());
        }
        return false;
    }
}
