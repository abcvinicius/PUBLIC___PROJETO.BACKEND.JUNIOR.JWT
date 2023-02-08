package com.projetoBackEnd.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoBackEnd.Controller.Request.UsuarioRequest;

public interface UsuarioRepository extends JpaRepository<UsuarioRequest, Long>{
	
	Optional<UsuarioRequest> findByEmail(String username);

}
