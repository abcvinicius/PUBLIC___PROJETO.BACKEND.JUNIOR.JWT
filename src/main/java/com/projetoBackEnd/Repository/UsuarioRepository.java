package com.projetoBackEnd.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projetoBackEnd.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findByUsername(String username);

	Optional<Usuario> findByEmail(String username);

}
