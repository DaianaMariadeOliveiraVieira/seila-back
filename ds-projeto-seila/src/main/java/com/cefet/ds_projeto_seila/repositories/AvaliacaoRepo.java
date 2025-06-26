package com.cefet.ds_projeto_seila.repositories;

import com.cefet.ds_projeto_seila.entities.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepo extends JpaRepository<Avaliacao, Long> {
}
