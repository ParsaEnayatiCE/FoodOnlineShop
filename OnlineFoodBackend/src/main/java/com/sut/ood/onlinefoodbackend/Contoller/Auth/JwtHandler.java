package com.sut.ood.onlinefoodbackend.Contoller.Auth;

import com.sun.net.httpserver.Headers;
import com.sut.ood.onlinefoodbackend.Model.DatabaseFacade;
import com.sut.ood.onlinefoodbackend.Model.Enum.Response;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component
public class JwtHandler {
    private final String secret = "YVNpbXBsZVNlY3JldEtleUJhc2U2NEVuY29kZWQzODRCaXRGb3JMaW5rZWRJblByb2plY3Q=";

    private final byte[] decodedKey = Base64.getDecoder().decode(secret);

    private final Key key = new SecretKeySpec(decodedKey, SignatureAlgorithm.HS384.getJcaName());

    @Autowired
    public DatabaseFacade databaseFacade;

    public String createJwtToken(String userId, String username, String password, String email, long expirationMillis) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        Date expiryDate = new Date(nowMillis + expirationMillis);

        return Jwts.builder()
                .setId(userId)
                .setIssuedAt(now)
                .setSubject("Login Credentials")
                .claim("username", username)
                .claim("password", password)
                .claim("email", email)
                .setExpiration(expiryDate)
                .signWith(key, SignatureAlgorithm.HS384)
                .compact();
    }

    public Claims decodeJwtToken(String jwt) {
        Jws<Claims> claimsJws = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwt);

        Claims claims = claimsJws.getBody();
        return claims;
    }

    public Response validateUserSession(String jwt) {
        Claims claims = null;
        try {
            claims = decodeJwtToken(jwt);
        }
        catch (io.jsonwebtoken.MalformedJwtException e) {
            e.printStackTrace();
            return Response.INVALID_TOKEN;
        }

        if(checkExpiryDate(claims.getExpiration())) {
            return Response.SESSION_EXPIRED;
        }

        if(!claims.getSubject().equals("Login Credentials")) {
            return Response.INVALID_TOKEN;
        }

        if(Objects.isNull(databaseFacade.CheckJwtCredentials(claims.get("username", String.class), claims.get("password", String.class), claims.get("email", String.class)))) {
            return Response.INVALID_TOKEN;
        }
        return Response.TOKEN_CHECKED_SUCCESSFULLY;
    }

    public String processSessionToken(Headers requestHeaders) throws SQLException {
        if (requestHeaders.containsKey("sessionToken")) {
            List<String> sessionTokens = requestHeaders.get("sessionToken");
            String sessionToken = sessionTokens.get(0);
            if(validateUserSession(sessionToken) == Response.TOKEN_CHECKED_SUCCESSFULLY) {
                return getUserNameFromJwtToken(sessionToken);
            }
            else {
                return null;
            }
        } else {
            return null;
        }
    }

    public String getUserNameFromJwtToken(String jwt) throws IllegalArgumentException, SQLException {
        Claims claims = decodeJwtToken(jwt);
        return claims.get("username", String.class);
    }
    public String getPasswordFromJwtToken(String jwt) throws IllegalArgumentException, SQLException {
        Claims claims = decodeJwtToken(jwt);
        return claims.get("password", String.class);
    }
    public String getEmailFromJwtToken(String jwt) throws IllegalArgumentException, SQLException {
        Claims claims = decodeJwtToken(jwt);
        return claims.get("email", String.class);
    }

    public boolean checkExpiryDate(Date expiryDate) {
        Date now = new Date(System.currentTimeMillis());
        return expiryDate.before(now);
    }
}
