package com.projetoBackEnd.dto.postagemDTO;

import java.util.List;
import java.util.stream.Collectors;

import com.projetoBackEnd.Model.Postagem;
import com.projetoBackEnd.dto.usuarioDTO.UsuarioDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostagemDTO {

    private String titulo;
	private String texto;
	private UsuarioDTO autor;
    
    public PostagemDTO() {}

    public PostagemDTO(UsuarioDTO autor) {
    	this.autor = autor;
    }

    public PostagemDTO(Postagem postagem) {
        this.titulo = postagem.getTitulo();
        this.texto = postagem.getTexto();
        this.autor = new UsuarioDTO(postagem.getAutor());
    }
    
    public static PostagemDTO convertEmDTO(Postagem postagem) {
        PostagemDTO postagemDTO = new PostagemDTO();
        postagemDTO.setTitulo(postagem.getTitulo());
        postagemDTO.setTexto(postagem.getTexto());
        postagemDTO.setAutor(new UsuarioDTO(postagem.getAutor()));
        return postagemDTO;
    }

	public static List<PostagemDTO> convertEmListPostagemDTO(List<Postagem> findAll) {
		return findAll.stream().map(PostagemDTO::new).collect(Collectors.toList());		
	}
}