//package com.projetoBackEnd.Utils;
//
//
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.projetoBackEnd.Controller.Request.PostagemRequest;
//import com.projetoBackEnd.Controller.Response.PostagemResponse;
//import com.projetoBackEnd.Model.Postagem;
//import com.projetoBackEnd.Model.Usuario;
//
//import lombok.Builder;
//import lombok.Data;
//
//
//@Component
//@Builder
//@Data
//public class PostagemBuilder {
//
//
//	@Autowired
//	UsuarioBuilder usuarioBuilder;
//
//		
//	public List<PostagemResponse> buildPostagemResponse(List<Postagem> postagem) {
//
//		return postagem.stream().map(postagens -> buildPostagemResponse(postagens)).collect(Collectors.toList());
//
//	}
//
//	public PostagemResponse buildPostagemResponse(Postagem postagem) {
//
//		return PostagemResponse.builder()
//				.id(postagem.getId())
//				.titulo(postagem.getTitulo())
//				.texto(postagem.getTexto())
//				.autor(usuarioBuilder.usuarioResponseBuild(postagem.getAutor()))
//				.build();
//	}
//
//	public Postagem buildPostagem(PostagemRequest postagemRequest, Usuario autor) {
//
//		return 	Postagem.builder()
//						.titulo(postagemRequest.getTitulo())
//						.texto(postagemRequest.getTexto())
//						.autor(autor)
//						.build();
//
//	}
//
//}