//package com.projetoBackEnd.Controller.EndPoints;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import com.projetoBackEnd.Controller.Request.PostagemRequest;
//import com.projetoBackEnd.Controller.Response.PostagemResponse;
//import com.projetoBackEnd.Repository.PostagemRepository;
//import com.projetoBackEnd.Service.PostagemService;
//import com.projetoBackEnd.Utils.PostagemBuilder;
//
//import java.net.URI;
//import java.util.List;
//
//@RestController
//@RequestMapping("/postagem")
//public class PostagemController {
//
//	@Autowired
//	PostagemService postagemService;
//
//	@Autowired
//	PostagemBuilder postagemBuilder;
//
//	@Autowired
//	PostagemRepository postagemRepository;
//
//	@PostMapping("/post")
//	public ResponseEntity<PostagemResponse> cadastro(@RequestBody @Validated PostagemRequest postagemRequest,
//			UriComponentsBuilder uriBuilder) throws Exception {
//		PostagemResponse postagem = postagemService.salvar(postagemRequest);
//		URI uri = uriBuilder.path("/post/{id}").buildAndExpand(postagem.getId()).toUri();
//		return ResponseEntity.created(uri).body(postagem);
//	}
//
//	@GetMapping("/post")
//	public List<PostagemResponse> listar() {
//		return postagemService.buscar();
//	}
//
//	@GetMapping("post/{id}")
//	public ResponseEntity<PostagemResponse> listarPorId(@PathVariable Long id) {
//		try {
//			PostagemResponse postagemResponse = postagemService.buscarPorId(id);
//			return ResponseEntity.ok(postagemResponse);
//		} catch (Exception e) {
//			return ResponseEntity.notFound().build();
//		}
//	}
//
//	@PutMapping("/post/{id}")
//	public ResponseEntity<PostagemResponse> atualizar(@PathVariable("id") Long id,
//			@RequestBody @Validated PostagemResponse postagemResponse, UriComponentsBuilder uriBuilder)
//			throws Exception {
//		postagemResponse.setId(id);
//		PostagemResponse postagem = postagemService.atualizar(postagemResponse);
//		URI uri = uriBuilder.path("/post/{id}").buildAndExpand(postagem.getId()).toUri();
//		return ResponseEntity.created(uri).body(postagem);
//	}
//
//	@DeleteMapping("/post/{id}")
//	public ResponseEntity<String> deletarPostagem(@PathVariable("id") Long id) {
//		try {
//			postagemService.deletar(id);
//			return ResponseEntity.ok("Postagem deletada com sucesso!");
//		} catch (Exception e) {
//			return ResponseEntity.badRequest().body(e.getMessage());
//		}
//	}
//}