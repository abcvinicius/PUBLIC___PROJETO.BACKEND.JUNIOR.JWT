package com.projetoBackEnd.Controller.EndPoints;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoBackEnd.Controller.Request.UsuarioRequest;
import com.projetoBackEnd.Controller.Response.UsuarioResponse;
import com.projetoBackEnd.Repository.UsuarioRepository;
import com.projetoBackEnd.Service.PostagemService;
import com.projetoBackEnd.Service.UsuarioService;

@RequestMapping("/autenticar")
@RestController
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	PostagemService postagemService;
	
	@PostMapping("/salvarusuario")
	public UsuarioResponse save(@RequestBody UsuarioRequest usuarioRequest) {
		return usuarioService.save(usuarioRequest);
	}
	@GetMapping("/buscarusuario")
	public List<UsuarioResponse> search() {
		return usuarioService.search();
	}

	@GetMapping("/buscarusuario/{id}")
	public UsuarioResponse getUsuarioById(@PathVariable Long id) throws AccountNotFoundException {
		return usuarioService.FindById(id);
	}
	
}
