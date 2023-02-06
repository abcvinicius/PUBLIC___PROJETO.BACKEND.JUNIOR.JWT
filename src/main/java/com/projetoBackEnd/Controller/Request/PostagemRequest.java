package com.projetoBackEnd.Controller.Request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostagemRequest {
	
	private String titulo;
	
	private String texto;

	private UsuarioRequestId autor;
	
}