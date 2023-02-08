//package com.projetoBackEnd.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.projetoBackEnd.Controller.Request.PostagemRequest;
//import com.projetoBackEnd.Controller.Request.UsuarioRequest;
//import com.projetoBackEnd.Controller.Response.PostagemResponse;
//import com.projetoBackEnd.Model.Postagem;
//import com.projetoBackEnd.Repository.PostagemRepository;
//import com.projetoBackEnd.Repository.UsuarioRepository;
////import com.projetoBackEnd.Utils.PostagemBuilder;
//
//@Service
//public class PostagemService {
//
//	@Autowired
//	//PostagemBuilder postagemBuilder;
//
//	@Autowired
//	PostagemRepository postagemRepository;
//
//	@Autowired
//	UsuarioRepository usuarioRepository;
//
//	public PostagemResponse salvar(PostagemRequest postagemRequest) throws Exception {
//		Optional<UsuarioRequest> usuarioOptional = usuarioRepository.findById(postagemRequest.getAutor().getId());
////		if (usuarioOptional.isPresent()) {
////			return postagemBuilder.buildPostagemResponse(
////					postagemRepository.save(postagemBuilder.buildPostagem(postagemRequest, usuarioOptional.get())));
////		}
//		throw new Exception("Autor não existente!");
//	}
//
//	public List<PostagemResponse> buscar() {
//		return postagemBuilder.buildPostagemResponse(postagemRepository.findAll());
//	}
//
//	public PostagemResponse buscarPorId(Long id) throws Exception {
//		Optional<Postagem> postagemOptional = postagemRepository.findById(id);
//		if (postagemOptional.isPresent()) {
//			return postagemBuilder.buildPostagemResponse(postagemOptional.get());
//		}
//		throw new Exception("Postagem não encontrada!");
//	}
//
//	public String deletar(Long id) throws Exception {
//		Optional<Postagem> postagemOptional = postagemRepository.findById(id);
//		if (postagemOptional.isPresent()) {
//			postagemRepository.deleteById(id);
//			return "Postagem deletada com sucesso.";
//		}
//		throw new Exception("Postagem não encontrada!");
//	}
//
//	public PostagemResponse atualizar(PostagemResponse postagemResponse) throws Exception {
//		Optional<Postagem> postagemOptional = postagemRepository.findById(postagemResponse.getId());
//		if (postagemOptional.isPresent()) {
//			Postagem postagem = postagemOptional.get();
//			postagem.setTitulo(postagemResponse.getTitulo());
//			postagem.setTexto(postagemResponse.getTexto());
//			return postagemBuilder.buildPostagemResponse(postagemRepository.save(postagem));
//		}
//		throw new Exception("Postagem não encontrada!");
//	}
//
//	/*
//	 * public PostagemResponse atualizar(PostagemRequest postagemRequest) throws
//	 * Exception { Optional<Postagem> postagemOptional =
//	 * postagemRepository.findById(postagemRequest.getAutor().getId()); if
//	 * (postagemOptional.isPresent()) { Postagem postagem = postagemOptional.get();
//	 * postagem.setTitulo(postagemRequest.getTitulo());
//	 * postagem.setTexto(postagemRequest.getTexto()); return
//	 * postagemBuilder.buildPostagemResponse(postagemRepository.save(postagem)); }
//	 * throw new Exception("Postagem não encontrada!"); }
//	 */
//}