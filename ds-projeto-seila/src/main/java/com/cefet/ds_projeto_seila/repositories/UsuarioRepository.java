package com.cefet.ds_projeto_seila.repositories;
import com.cefet.ds_projeto_seila.entities.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByLogin(String login);
    boolean existsByLogin(String login);

}
