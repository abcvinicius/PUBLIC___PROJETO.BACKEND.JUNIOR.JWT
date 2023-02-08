package com.projetoBackEnd.Controller.Response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponse {

		private Long id;
		
		private String nome;
		
		private String username;
		
		private String email;
		
		private String senha;
		
		private List<PostagemResponse> postagem;

}
