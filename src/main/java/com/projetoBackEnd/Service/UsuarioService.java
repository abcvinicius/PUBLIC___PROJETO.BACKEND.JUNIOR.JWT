package com.projetoBackEnd.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projetoBackEnd.Controller.EndPoints.UsuarioDTO;
import com.projetoBackEnd.Controller.Request.UsuarioRequest;
import com.projetoBackEnd.Controller.Response.UsuarioResponse;
import com.projetoBackEnd.Repository.UsuarioRepository;


@Service
public class UsuarioService {


	@Autowired
	UsuarioRepository usuarioRepository;

	public UsuarioDTO salvar(UsuarioRequest usuarioRequest) {
		BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
		usuarioRequest.setSenha(crypt.encode(usuarioRequest.getSenha()));
		UsuarioRequest user =  usuarioRepository.save(usuarioRequest);
		 
		 return UsuarioDTO.convertEmDTO(user);
	}

	public List<UsuarioRequest> buscar(){
	return (usuarioRepository.findAll());

	}

}