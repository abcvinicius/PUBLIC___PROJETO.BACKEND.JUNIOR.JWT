package com.projetoBackEnd.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.projetoBackEnd.Controller.Request.UsuarioRequest;
import com.projetoBackEnd.Controller.Response.PostagemResponse;
import com.projetoBackEnd.Controller.Response.UsuarioResponse;
import com.projetoBackEnd.Model.Usuario;



@Component
public class UsuarioBuilder {



	//List
	public List<UsuarioResponse> buildUsuarioResponse(List<Usuario> usuario){
		return usuario.stream().map(usuarios -> buildUsuarioResponse(usuarios)).collect(Collectors.toList());
    };
	
	//Response
    public static UsuarioResponse buildUsuarioResponse(Usuario usuario) {
    	
    	List<PostagemResponse> postagens = new ArrayList<>();
        
    	if (usuario.getPostagens() != null) {
            postagens = usuario.getPostagens().stream().map(postagem -> PostagemResponse
            		.builder()
               		.texto(postagem.getTexto())
                	.build())
            		.collect(Collectors.toList());
        }
    	
        return UsuarioResponse.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .senha(usuario.getSenha())
                .postagens(postagens)
                .build();
        }

    //Request
    public Usuario buildUsuario(UsuarioRequest usuarioRequest) {
        return Usuario.builder()
            .nome(usuarioRequest.getNome())
            .email(usuarioRequest.getEmail())
            .senha(usuarioRequest.getSenha())
            .build();
    }
}

