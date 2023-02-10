package com.projetoBackEnd.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.projetoBackEnd.Model.Usuario;

public class UsuarioDTO {
	
	
	private String nome;	

	private String password;	
	
	private String email;	

	
	
	
/* ------------------------------- */
	//EMAIL POSSUI UM SET CASO QUEIRA MUDAR O EMAIL DEPOIS
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
/* ------------------------------- */
	

	
/* ------------------------------- */
	
	public String getUsuario() {
		return nome;
	}
	public String getPassword() {
		return password;
	}
/* ------------------------------- */
	
	
	
/* ------------------------------- */	
	public UsuarioDTO(Usuario user) {
		this.nome = user.getNome();
	}
/* ------------------------------- */

	
	
	public static UsuarioDTO convertEmDTO(Usuario user) {
		return new UsuarioDTO(user.getNome(),user.getEmail(),user.getPassword());
	}

	
	
	
	public UsuarioDTO(String nome, String email, String password) {
		this.nome = nome;
		this.email = email;
		this.password = password;
	}
	
	
	
	public static List<UsuarioDTO> convertEmListDTO(List<Usuario> findAll) {
		return findAll.stream().map(UsuarioDTO::new).collect(Collectors.toList());		
	}	
	/*
	 *  findAll: esta é uma lista de objetos que são retornados por alguma chamada de método anterior no código. No caso List<Usuario>
	 * 
	 * .stream(): este método transforma a lista em um "fluxo de dados", permitindo a aplicação de operações intermediárias e opereções terminais sobre os elementos da lista.
	 * 
	 * .map(UsuarioDTO::new): esta é uma operação intermediária que mapeia cada elemento da lista para um novo objeto do tipo UsuarioDTO. A notação UsuarioDTO::new é uma referência ao construtor padrão da classe UsuarioDTO.
	 * 
	 * .collect(Collectors.toList()): esta é uma operação terminal que coleta todos os elementos mapeados pelo map e os retorna como uma nova lista. A notação Collectors.toList() é uma referência ao método estático toList da classe Collectors que retorna uma instância de Collector que coleta os elementos em uma lista.
	 * 
	 * No final, este trecho de código é responsável por transformar uma lista de objetos em uma nova lista de objetos do tipo UsuarioDTO.
	 */
	

	public UsuarioDTO() { }
	
	
	
}
