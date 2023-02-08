package com.projetoBackEnd.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projetoBackEnd.Controller.Request.UsuarioRequest;
import com.projetoBackEnd.Controller.Response.UsuarioResponse;
import com.projetoBackEnd.Repository.UsuarioRepository;


@Service
public class UsuarioService {


	@Autowired
	UsuarioRepository usuarioRepository;

	public UsuarioRequest salvar(UsuarioRequest usuarioRequest) {
		BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
		usuarioRequest.setSenha(crypt.encode(usuarioRequest.getSenha()));
		return usuarioRepository.save(usuarioRequest);
	}

	public List<UsuarioRequest> buscar(){
	return (usuarioRepository.findAll());

	}

}