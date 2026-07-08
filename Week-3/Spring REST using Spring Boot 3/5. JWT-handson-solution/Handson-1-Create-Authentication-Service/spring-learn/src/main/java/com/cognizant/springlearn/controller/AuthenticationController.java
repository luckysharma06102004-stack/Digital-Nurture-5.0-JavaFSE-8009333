package com.cognizant.springlearn.controller;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@RestController
public class AuthenticationController {
    private static final Logger LOGGER =
        LoggerFactory.getLogger(AuthenticationController.class);
    private static final SecretKey SECRET_KEY =
        Keys.secretKeyFor(SignatureAlgorithm.HS256);
    @GetMapping("/authenticate")
    public Map<String, String> authenticate(
            @RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start");
        LOGGER.debug("Auth Header: {}", authHeader);
        String user = getUser(authHeader);
        String token = generateJwt(user);
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        LOGGER.info("End");
        return map;
    }
    private String getUser(String authHeader) {
        LOGGER.info("Start");
        String encodedCredentials = authHeader.substring("Basic ".length());
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String decodedString = new String(decodedBytes);
        String user = decodedString.split(":")[0];
        LOGGER.debug("User: {}", user);
        LOGGER.info("End");
        return user;
    }
    private String generateJwt(String user) {
        LOGGER.info("Start");
        String token = Jwts.builder()
            .setSubject(user)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 1200000))
            .signWith(SECRET_KEY)
            .compact();
        LOGGER.debug("Token: {}", token);
        LOGGER.info("End");
        return token;
    }
}