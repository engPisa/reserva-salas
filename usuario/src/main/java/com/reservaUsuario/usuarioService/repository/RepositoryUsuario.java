package com.reservaUsuario.usuarioService.repository;

import com.reservaUsuario.usuarioService.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUsuario extends JpaRepository<UsuarioModel, Long> {
  boolean existsByCpf(String cpf);
}
