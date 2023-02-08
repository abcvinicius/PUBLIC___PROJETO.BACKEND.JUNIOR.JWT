package com.projetoBackEnd.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.projetoBackEnd.Controller.Request.UsuarioRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "postagem_seq")
	@SequenceGenerator(name = "postagem_seq", sequenceName = "postagem_seq", allocationSize = 1)
	@EqualsAndHashCode.Include
	private Long id;

	private String titulo;

	private String texto;
	
	@ManyToOne	    
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private UsuarioRequest autor;


}
