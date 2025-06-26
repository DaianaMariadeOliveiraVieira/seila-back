package com.cefet.ds_projeto_seila.repositories;

import com.cefet.ds_projeto_seila.entities.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepo extends JpaRepository<Filme, Long> {
}
