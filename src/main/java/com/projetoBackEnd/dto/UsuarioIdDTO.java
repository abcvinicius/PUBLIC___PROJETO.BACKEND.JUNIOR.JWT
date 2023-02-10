package com.projetoBackEnd.dto;


import java.util.List;
import java.util.stream.Collectors;

import com.projetoBackEnd.Model.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioIdDTO {
	
	private Long id;

	
	public UsuarioIdDTO(Usuario user) {
		this.id = user.getId();
	}


	public static UsuarioIdDTO convertEmIdDTO(Usuario user) {
		return new UsuarioIdDTO(user.getId());
	}

	public static List<UsuarioIdDTO> convertEmListIdDTO(List<Usuario> findAll) {
		return findAll.stream().map(UsuarioIdDTO::new).collect(Collectors.toList());		
	}	


}