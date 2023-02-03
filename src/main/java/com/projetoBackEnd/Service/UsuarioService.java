package com.projetoBackEnd.Service;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projetoBackEnd.Controller.Request.PostagemRequest;
import com.projetoBackEnd.Controller.Request.UsuarioRequest;
import com.projetoBackEnd.Controller.Response.UsuarioResponse;
import com.projetoBackEnd.Model.Usuario;
import com.projetoBackEnd.Repository.UsuarioRepository;
import com.projetoBackEnd.Utils.UsuarioBuilder;

@Service
public class UsuarioService {
private UsuarioRepository usuarioRepository;
private UsuarioBuilder usuarioBuilder;

	@Autowired
	private PostagemService postagemService;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository, UsuarioBuilder usuarioBuilder) {
    	this.usuarioRepository = usuarioRepository;
    	this.usuarioBuilder = usuarioBuilder;
	}

	//METODO SALVAR USUARIO - POST
	public UsuarioResponse save(UsuarioRequest usuarioRequest) {
		
		return UsuarioBuilder.buildUsuarioResponse(usuarioRepository.save(usuarioBuilder.buildUsuario(usuarioRequest)));
	}		
	
	//METODO BUSCAR USUARIOS - GET
	public List<UsuarioResponse> search(){
		return usuarioBuilder.buildUsuarioResponse(usuarioRepository.findAll());
	}
	
	//METODO BUSCAR POR ID - GET
	public UsuarioResponse FindById(Long id) throws AccountNotFoundException {    
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.map(value -> UsuarioBuilder.buildUsuarioResponse(value)).orElseThrow(() -> new AccountNotFoundException("Usuário POR ID não encontrado"));
	}

	//METODO CRIAR UMA POSTAGEM
	public ResponseEntity<Void> criarPostagem(Long usuarioId, PostagemRequest postagemRequest) throws AccountNotFoundException {
	    Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new AccountNotFoundException("Metodo de Criar postagem por Usaurio // FALHA"));
	    postagemService.criarPostagem(postagemRequest, usuarioId);
	    return ResponseEntity.ok().build();
	  }

}