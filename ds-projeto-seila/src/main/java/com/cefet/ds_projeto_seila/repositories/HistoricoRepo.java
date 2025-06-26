package com.cefet.ds_projeto_seila.repositories;

import com.cefet.ds_projeto_seila.entities.Historico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoRepo extends JpaRepository<Historico, Long> {
}
