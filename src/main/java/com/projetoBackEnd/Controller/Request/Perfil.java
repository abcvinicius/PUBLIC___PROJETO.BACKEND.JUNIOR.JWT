package com.projetoBackEnd.Controller.Request;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Entity
@Data
public class Perfil implements GrantedAuthority {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idUsuario;
	
	private String nome;

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return nome;
	}
	
}
