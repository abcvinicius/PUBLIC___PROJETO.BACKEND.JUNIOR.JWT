package com.projetoBackEnd.Controller.EndPoints;



import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.projetoBackEnd.Controller.Request.UsuarioRequest;
import com.projetoBackEnd.Controller.Response.UsuarioResponse;
import com.projetoBackEnd.Service.UsuarioService;



@RequestMapping("")
@RestController
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@PostMapping("/register")
	public ResponseEntity<UsuarioResponse> cadastro(@RequestBody @Validated UsuarioRequest usuarioRequest,
			UriComponentsBuilder uriBuilder) throws Exception {
		UsuarioResponse usuario = usuarioService.salvar(usuarioRequest);
		URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(usuario);
	}	
}
