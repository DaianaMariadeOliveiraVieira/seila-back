package com.cefet.ds_projeto_seila.repositories;
import java.util.List;

import com.cefet.ds_projeto_seila.entities.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepo extends JpaRepository<Perfil, Long> {
    List<Perfil> findAllByClienteId(Long clienteId);
}