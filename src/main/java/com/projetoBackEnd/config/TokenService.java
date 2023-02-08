package com.projetoBackEnd.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.projetoBackEnd.Controller.Request.UsuarioRequest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	@Value("${forum.jwt.expiration}")
	private String expiration;
	
	@Value("${forum.jwt.secret}")
	private String secret;

	public TokenTriangulador gerarToken(Authentication authentication) {
		UsuarioRequest logado = (UsuarioRequest) authentication.getPrincipal();
		Date hoje = new Date();
		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
		   
		String token = Jwts.builder()
		.setIssuer("API Gestor de atendimento ")
		.setSubject(logado.getId().toString())
		.setIssuedAt(hoje)
		.setExpiration(dataExpiracao)
		.signWith(SignatureAlgorithm.HS256, secret)
		.compact();
		
		
		return TokenTriangulador.builder()
				.token(token)
				.dataDeExpiracao(dataExpiracao)
				.build();
	}
	
	public boolean isTokenValido(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Long getIdUsuario(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
	}

}