package com.projetoBackEnd.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.projetoBackEnd.Controller.Request.PostagemRequest;
import com.projetoBackEnd.Controller.Response.PostagemResponse;
import com.projetoBackEnd.Model.Postagem;
import com.projetoBackEnd.Model.Usuario;
import com.projetoBackEnd.Repository.PostagemRepository;
import com.projetoBackEnd.Repository.UsuarioRepository;
import com.projetoBackEnd.Utils.PostagemBuilder;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class PostagemService {

    @Autowired
    private PostagemRepository postagemRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PostagemBuilder postagemBuilder;

    public PostagemResponse criarPostagem(PostagemRequest postagemRequest, Long autorId) {
        Optional<Usuario> autor = usuarioRepository.findById(autorId);
        if (!autor.isPresent()) {
            throw new RuntimeException("Autor não encontrado");
        }

        Postagem postagem = postagemBuilder.buildPostagem(autor.get());
        Postagem postagemSalva = postagemRepository.save(postagem);
        return postagemBuilder.buildPostagemResponse(postagemSalva);
    }

    public List<PostagemResponse> buscarPostagens() {
        List<Postagem> postagens = postagemRepository.findAll();
        return postagemBuilder.buildPostagemResponse(postagens);
    }

    public PostagemResponse buscarPostagemPorId(Long id) {
        Optional<Postagem> postagem = postagemRepository.findById(id);
        if (!postagem.isPresent()) {
            throw new RuntimeException("Postagem não encontrada");
        }
        return postagemBuilder.buildPostagemResponse(postagem.get());
    }

}