package com.cefet.ds_projeto_seila.repositories;

import com.cefet.ds_projeto_seila.entities.Plano;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanoRepo extends JpaRepository<Plano, Long> {
    boolean existsByDescricao(String descricao);
}
