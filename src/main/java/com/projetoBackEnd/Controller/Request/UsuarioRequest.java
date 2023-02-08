package com.projetoBackEnd.Controller.Request;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class UsuarioRequest {

	
		private String email;

		private String senha;
		
		public UsernamePasswordAuthenticationToken converter() {
			return new UsernamePasswordAuthenticationToken(email, senha);
		}

}
