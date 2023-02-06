package com.projetoBackEnd.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoBackEnd.Controller.Request.UsuarioRequest;
import com.projetoBackEnd.Controller.Response.UsuarioResponse;
import com.projetoBackEnd.Repository.UsuarioRepository;
import com.projetoBackEnd.Utils.UsuarioBuilder;

@Service
public class UsuarioService {

	@Autowired
	UsuarioBuilder usuarioBuilder;
	@Autowired
	UsuarioRepository usuarioRepository;

	public UsuarioResponse salvar(UsuarioRequest usuarioRequest) {
		return usuarioBuilder.usuarioResponseBuild(usuarioRepository.save(usuarioBuilder.usuarioBuild(usuarioRequest)));
	}

	public List<UsuarioResponse> buscar(){
	return usuarioBuilder.usuarioResponseBuild(usuarioRepository.findAll());

	}

}