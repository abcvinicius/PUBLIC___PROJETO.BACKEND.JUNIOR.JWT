package com.projetoBackEnd.Service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projetoBackEnd.Model.Usuario;
import com.projetoBackEnd.Repository.UsuarioRepository;
import com.projetoBackEnd.dto.UsuarioCompletoDTO;
import com.projetoBackEnd.dto.UsuarioDTO;
import com.projetoBackEnd.dto.UsuarioIdDTO;


@Service
public class UsuarioService {


	@Autowired
	UsuarioRepository usuarioRepository;

	public UsuarioDTO salvar(Usuario usuario) {
		BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
		usuario.setSenha(crypt.encode(usuario.getSenha()));
		Usuario user =  usuarioRepository.save(usuario);
		 
		 return UsuarioDTO.convertEmDTO(user);
	}



	public List<UsuarioCompletoDTO> getTodosUsuarios() {
	    List<Usuario> usuarios = usuarioRepository.findAll();
	    List<UsuarioCompletoDTO> usuariosCompletosDTO = new ArrayList<>();
	    for (Usuario usuario : usuarios) {
	        UsuarioIdDTO id = new UsuarioIdDTO(usuario.getId());
	        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.getNome(), usuario.getEmail(), null);
	        UsuarioCompletoDTO usuarioCompleto = new UsuarioCompletoDTO(id, usuarioDTO);
	        usuariosCompletosDTO.add(usuarioCompleto);
	    }
	    return usuariosCompletosDTO;
	}
}