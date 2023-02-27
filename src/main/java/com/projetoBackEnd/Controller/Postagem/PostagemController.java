package com.projetoBackEnd.Controller.Postagem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.projetoBackEnd.Model.Postagem;
import com.projetoBackEnd.Service.PostagemService;
import com.projetoBackEnd.dto.postagemDTO.PostagemDTO;

@RequestMapping("")
@RestController
public class PostagemController {

	@Autowired
	PostagemService postagemService;
	
	//REGISTAR POSTAGEM
	@PostMapping("/post")
	public ResponseEntity<PostagemDTO> cadastro(@RequestBody @Validated Postagem postagem,
			UriComponentsBuilder uriBuilder) throws Exception {
		PostagemDTO postagens = postagemService.salvar(postagem);
		return  new ResponseEntity<PostagemDTO>(postagens,HttpStatus.CREATED);
	}	
	
	//PUXAR TODAS AS POSTAGENS
    @GetMapping("/post")
    public List<PostagemDTO> getTodasPostagens() {
        return postagemService.getTodasPostagens();
    }
    
    //PUXAR POSTAGEM POR ID
    @GetMapping("/post/{id}")
    public ResponseEntity<PostagemDTO> getPostagemPorId(@PathVariable Long id) {
    	return ResponseEntity.ok(postagemService.getPostagemPorId(id));
    }
    
    //EDITAR POSTAGEM
    @PutMapping("/post/{id}")
    public ResponseEntity<PostagemDTO> atualizarPostagem(@PathVariable Long id, @RequestBody PostagemDTO postagemDTO) {
        PostagemDTO postagemAtualizada = postagemService.atualizarPostagem(id, postagemDTO);
        return ResponseEntity.ok(postagemAtualizada);
    }
    
    //DELETAR
    @DeleteMapping("/post/{id}")
    public ResponseEntity<Void> deletarPostagem(@PathVariable Long id) {
        postagemService.deletarPostagem(id);
        return ResponseEntity.noContent().build();
    }    
}
