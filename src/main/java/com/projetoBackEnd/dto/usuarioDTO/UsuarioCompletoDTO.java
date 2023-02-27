package com.projetoBackEnd.dto.usuarioDTO;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioCompletoDTO {
   
	private UsuarioIdDTO id;
    
	private UsuarioDTO usuario;
	
	
	
	//Usuario DTO COMPLETO
	public static UsuarioCompletoDTO convertEmDTOCompleto(UsuarioIdDTO id, UsuarioDTO usuarioDTO) {
		return new UsuarioCompletoDTO(id, usuarioDTO);
		
	}


}


