package com.projetoBackEnd.Controller.Request;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class UsuarioRequest {

		@NonNull
		private String nome;
		@NonNull
		private String email;
		@NonNull
		private String senha;

}
