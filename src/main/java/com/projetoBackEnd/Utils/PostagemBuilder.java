package com.projetoBackEnd.Utils;


import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.projetoBackEnd.Controller.Request.PostagemRequest;
import com.projetoBackEnd.Controller.Response.PostagemResponse;
import com.projetoBackEnd.Model.Postagem;
import com.projetoBackEnd.Model.Usuario;

import lombok.Builder;
import lombok.Data;


@Component
@Builder
@Data
public class PostagemBuilder {

	@Bean
	public PostagemRequest postagemRequest() {
	    return new PostagemRequest();
	}
	
  private PostagemRequest postagemRequest;
  private PostagemResponse postagemResponse;

  public Postagem buildPostagem(PostagemRequest postagemRequest ,Usuario autor) {
    return Postagem.builder()
      .titulo(postagemRequest.getTitulo())
      .texto(postagemRequest.getTexto())
      .autor(autor)
      .build();
  }

  public PostagemResponse buildPostagemResponse(Postagem postagem) {
    return PostagemResponse.builder()
      .id(postagem.getId())
      .titulo(postagem.getTitulo())
      .texto(postagem.getTexto())
      .build();
  }
  
  public List<PostagemResponse> buildPostagemResponse(List<Postagem> postagem){
	  return (List<PostagemResponse>) postagem.stream().map(postagens -> buildPostagemResponse(postagens)).toList();
  }

}
