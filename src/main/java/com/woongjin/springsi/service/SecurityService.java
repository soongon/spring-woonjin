package com.woongjin.springsi.service;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class SecurityService {
	
	private static final String secretKey= "4C8kum4LxyKWYLM78sKdXrzbBjDCFyfX";

	public String generateToken(String userid) {
		   
	    // The JWT signature algorithm we will be using to sign the token
	    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;   
	    
	    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);
	    
	    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
	    
	    JwtBuilder builder = Jwts.builder()
	        .setSubject(userid)
	        .signWith(signatureAlgorithm, signingKey);
	    
	    long nowMillis = System.currentTimeMillis();    
	    builder.setExpiration(new Date(nowMillis + (1000 * 600))); 
	    
	    return builder.compact();
	}

	public String parseToken(String token) {
		
		Claims claims = Jwts.parser()              
	            .setSigningKey(DatatypeConverter.parseBase64Binary(secretKey))
	            .parseClaimsJws(token).getBody();
		
	    return claims.getSubject();
	}

}
