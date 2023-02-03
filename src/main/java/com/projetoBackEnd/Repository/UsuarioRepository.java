package com.projetoBackEnd.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoBackEnd.Controller.Response.UsuarioResponse;
import com.projetoBackEnd.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findById(UsuarioResponse usuarioResponse);

}
