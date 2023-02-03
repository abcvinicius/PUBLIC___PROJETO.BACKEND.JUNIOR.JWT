package com.projetoBackEnd.Controller.EndPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.projetoBackEnd.Controller.Request.PostagemRequest;
import com.projetoBackEnd.Controller.Response.PostagemResponse;
import com.projetoBackEnd.Service.PostagemService;

import java.util.List;

@RestController
@RequestMapping("/postagem")
public class PostagemController {

    @Autowired
    private PostagemService postagemService;

    @PostMapping
    public PostagemResponse criarPostagem(@RequestBody PostagemRequest postagemRequest) {
        return postagemService.criarPostagem(postagemRequest, null);
    }

    @GetMapping
    public List<PostagemResponse> buscarPostagens() {
        return postagemService.buscarPostagens();
    }

    @GetMapping("/{id}")
    public PostagemResponse buscarPostagemPorId(@PathVariable Long id) {
        return postagemService.buscarPostagemPorId(id);
    }
}