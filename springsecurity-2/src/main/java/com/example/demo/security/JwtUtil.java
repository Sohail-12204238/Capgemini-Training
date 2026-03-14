package com.example.demo.security;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.example.demo.Studentsecurity2Application;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	private final Key key;
	
	public JwtUtil(@Value("${jwt.secret}") String secret, Studentsecurity2Application studentsecurity2Application) {
		this.key = Keys.hmacShaKeyFor(Base64.getDecoder().decode(secret));
	}
	
	public String generateToken(String userName,String role) {
		return Jwts.builder().setSubject(userName).claim("role",role)
				.setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7))
				.signWith(key, SignatureAlgorithm.HS256).compact();
	}
	
	public String refreshToken(String userName,String role) {
		return Jwts.builder().setSubject(userName)
				.setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
				.signWith(key, SignatureAlgorithm.HS256).compact();
	}
	
	private Claims getClaimsFromToken(String token) {
		return Jwts.parserBuilder().setSigningKey(key).build()
				.parseClaimsJws(token).getBody();
	}
	
	public String getUserNameFromToken(String token) {
		return getClaimsFromToken(token).getSubject();
	}
	
	public boolean isTokenExpired(String token) {
		return getClaimsFromToken(token).getExpiration().before(new Date());
	}
	
	public String getRoleFromToken(String token) {
		return (String) getClaimsFromToken(token).get("role");
	}
}
