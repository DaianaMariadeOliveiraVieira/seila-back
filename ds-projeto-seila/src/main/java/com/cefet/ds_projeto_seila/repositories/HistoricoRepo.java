package com.cefet.ds_projeto_seila.repositories;

import com.cefet.ds_projeto_seila.entities.Historico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoricoRepo extends JpaRepository<Historico, Long> {
    List<Historico> findByClienteId(Long clienteId);
}
