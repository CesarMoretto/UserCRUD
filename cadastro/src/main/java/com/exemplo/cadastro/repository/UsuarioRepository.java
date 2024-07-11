package com.exemplo.cadastro.repository;

import com.exemplo.cadastro.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
