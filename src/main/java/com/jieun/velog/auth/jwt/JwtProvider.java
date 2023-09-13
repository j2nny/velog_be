package com.jieun.velog.auth.jwt;

import com.jieun.velog.model.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.TextCodec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtProvider {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.token.message}")
    private String message;

    private static final long TOKEN_VALID_TIME = 24 * 60 * 60 * 1000L; // 24시간
    private static final long REFRESH_TOKEN_VALID_TIME = 30 * 24 * 60 * 60 * 1000L; // 30일

    private SigningKeyResolver resolver = new SigningKeyResolverAdapter() {
        @Override
        public byte[] resolveSigningKeyBytes(JwsHeader header, Claims claims) {
            log.info("Decoded secret : {}", new String(TextCodec.BASE64.decode(secretKey)));
            return TextCodec.BASE64.decode(secretKey);
        }
    };

    public String generateToken(User user) {
        log.info("decoded key : {}", new String(TextCodec.BASE64.decode(secretKey)));
        Date now = new Date();
        String token = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setIssuer(issuer)
                .setSubject(user.getEmail())
                .claim("userNo", user.getUserNo())
                .claim("id", user.getId())
                .claim("email", user.getEmail())
                .claim("name", user.getName())
                .setIssuedAt(now) // Fri Jun 24 2016 15:33:42 GMT-0400 (EDT)
                .setExpiration(new Date(now.getTime() + TOKEN_VALID_TIME))
                .signWith(
                        SignatureAlgorithm.HS256,
                        TextCodec.BASE64.decode(secretKey)
                )
                .compact();

        log.info("Generated Token : {}", token);
        return token;
    }

    public User parseJws(String token) {
        log.info("input token : {}", token);
        Claims claims = Jwts.parser()
                .setSigningKeyResolver(resolver)
                .parseClaimsJws(removeBearer(token))
                .getBody();
        return User.builder()
                .userNo((Integer) claims.getOrDefault("userNo", 0))
                .id(claims.getOrDefault("id", "").toString())
                .email(claims.getOrDefault("email", "").toString())
                .name(claims.getOrDefault("name", "").toString())
                .build();
    }

    public boolean validateToken(String token) {
        try {
            return !Jwts.parser()
                    .setSigningKeyResolver(resolver)
                    .parseClaimsJws(removeBearer(token))
                    .getBody()
                    .getExpiration().before(new Date());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("Invalid Token");
        }
    }

    private String removeBearer(String token) {
        return token.replace("Bearer", "").trim();
    }
}
