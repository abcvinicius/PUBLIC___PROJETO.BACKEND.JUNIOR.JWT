package com.projetoBackEnd.Controller.EndPoints;

import java.util.List;
import java.util.stream.Collectors;

import com.projetoBackEnd.Controller.Request.UsuarioRequest;

public class UsuarioDTO {
	
	
	private String usuario;	

	private String password;	
	
	private String email;	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UsuarioDTO(UsuarioRequest user) {
		this.usuario = user.getUsuario();
	}

	public String getUsuario() {
		return usuario;
	}


	public String getPassword() {
		return password;
	}


	public static UsuarioDTO convertEmDTO(UsuarioRequest user) {
		// TODO Auto-generated method stub
		return new UsuarioDTO(user.getUsuario(),user.getPassword(),user.getEmail());
	}

	public static List<UsuarioDTO> convertEmListDTO(List<UsuarioRequest> findAll) {
		
		return findAll.stream()
				.map(UsuarioDTO::new)
				.collect(Collectors.toList());		
	}	
	
	public UsuarioDTO() {
		
	}

	public UsuarioDTO(String usuario, String password, String email) {
		this.usuario = usuario;
		this.password = password;
		this.email = email;
	}


}