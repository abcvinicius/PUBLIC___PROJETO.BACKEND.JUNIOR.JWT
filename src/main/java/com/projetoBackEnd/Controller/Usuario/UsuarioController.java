package com.projetoBackEnd.Controller.Usuario;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.projetoBackEnd.Model.Usuario;
import com.projetoBackEnd.Service.UsuarioService;
import com.projetoBackEnd.dto.usuarioDTO.UsuarioCompletoDTO;
import com.projetoBackEnd.dto.usuarioDTO.UsuarioDTO;



@RequestMapping("")
@RestController
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@PostMapping("/register")
	public ResponseEntity<UsuarioDTO> cadastro(@RequestBody @Validated Usuario usuarioRequest,
			UriComponentsBuilder uriBuilder) throws Exception {
		UsuarioDTO usuario = usuarioService.salvar(usuarioRequest);
		return  new ResponseEntity<UsuarioDTO>(usuario,HttpStatus.CREATED);
	}	
	
	//controller
	@GetMapping("/getUsuarios")
	public ResponseEntity<List<UsuarioCompletoDTO>> getTodosUsuarios() {
	    List<UsuarioCompletoDTO> listaUsuarios = usuarioService.getTodosUsuarios();
	    return ResponseEntity.ok().body(listaUsuarios);
	}
}