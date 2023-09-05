package mbds.tpt.egouvernance_javaserver.helpers;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import mbds.tpt.egouvernance_javaserver.models.User;

@Component
public class JwtTokenUtil implements Serializable {
    private static final long serialVersionUID = -3627653283728L;

    public static final long JWT_TOKEN_VALIDITY = 60 * 60000;

    @Value("${jwt.secret}")
    private String secret;

    public String getUserIdFromToken(String token) {
        return getClaimsFromToken(token, Claims::getSubject);
    }

    public <T> T getClaimsFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimsFromToken(token, Claims::getExpiration);
    }

    public Boolean isTokenExpired(String token){
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }


    public String generateToken(User user){
        Map<String,Object> claims = new HashMap();
        return doGenerateToken(claims, user.getId());
    }

    private String doGenerateToken(Map<String,Object> claims,String subject){
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis()+JWT_TOKEN_VALIDITY)).signWith(SignatureAlgorithm.HS512,secret).compact();
    }

    public Boolean validateToken(String token,User user){
        final String id = getUserIdFromToken(token);
        return (id.equals(user.getId()) && !isTokenExpired(token));
    }
}