package com.projetoBackEnd.Model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

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
	private Usuario autor;


}
