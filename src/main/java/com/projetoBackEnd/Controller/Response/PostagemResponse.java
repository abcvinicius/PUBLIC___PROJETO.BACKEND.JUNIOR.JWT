package com.projetoBackEnd.Controller.Response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostagemResponse {
	  private Long id;
	  private String titulo;
	  private String texto;
	  // getters e setters
	}