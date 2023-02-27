package com.projetoBackEnd.Service;

	import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoBackEnd.Model.Postagem;
import com.projetoBackEnd.Repository.PostagemRepository;
import com.projetoBackEnd.dto.postagemDTO.PostagemDTO;

@Service
public class PostagemService {

	@Autowired
	PostagemRepository postagemRepository;
	
	//PUSH SALVAR POSTAGENS
	public PostagemDTO salvar(Postagem postagem) {
		Postagem post = postagemRepository.save(postagem);
		return PostagemDTO.convertEmDTO(post);
	}

	//GET TODAS POSTAGENS
	public List<PostagemDTO> getTodasPostagens() {
	    List<Postagem> postagens = postagemRepository.findAll();
	    return PostagemDTO.convertEmListPostagemDTO(postagens);
	}
	
	
	//GET POSTAGEM POR ID
	 public PostagemDTO getPostagemPorId(Long id) {
	        Optional<Postagem> postagemOptional = postagemRepository.findById(id);
	        if (postagemOptional.isPresent()) {
	            PostagemDTO postagemDTO = PostagemDTO.convertEmDTO(postagemOptional.get());
	            return postagemDTO;
	        } else {
	            throw new EntityNotFoundException("Postagem não encontrada");
	        }
	    }
	 
	//PUT ATUALIZAR POSTAGENS 	
	public PostagemDTO atualizarPostagem(Long id, PostagemDTO postagemDTO) {
	    Optional<Postagem> postagemOptional = postagemRepository.findById(id);
	    if (postagemOptional.isPresent()) {
	        Postagem postagem = postagemOptional.get();
	        postagem.setTitulo(postagemDTO.getTitulo());
	        postagem.setTexto(postagemDTO.getTexto());
	        postagemRepository.save(postagem);
	        return PostagemDTO.convertEmDTO(postagem);
	    } else {
	        throw new EntityNotFoundException("Postagem não encontrada");
	    }
	}
	
	//DELETAR POSTAGENS
	//MÉTODO ANTIGO -> public ResponseEntity<Void> deletarPostagem(Long id) 
	//DIMINUI O CÓDIGO
	public void deletarPostagem(Long id) {
	    Optional<Postagem> postagemOptional = postagemRepository.findById(id);
	    if (postagemOptional.isPresent()) {
	        postagemRepository.delete(postagemOptional.get());
	    } else {
	        throw new EntityNotFoundException("Postagem não encontrada");
	    }
	}
}