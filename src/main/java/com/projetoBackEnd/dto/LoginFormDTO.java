package com.projetoBackEnd.dto;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class LoginFormDTO {
	
	private String email;
	private String senha;
	
	
	
	
	public UsernamePasswordAuthenticationToken convert() {
		// TODO Auto-generated method stub
		return new UsernamePasswordAuthenticationToken(email,senha);
	}
	
	

}
