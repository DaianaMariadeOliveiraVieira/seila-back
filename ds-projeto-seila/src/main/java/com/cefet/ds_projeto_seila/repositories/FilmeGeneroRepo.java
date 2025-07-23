package com.cefet.ds_projeto_seila.repositories;

import com.cefet.ds_projeto_seila.entities.Filme;
import com.cefet.ds_projeto_seila.entities.FilmeGenero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmeGeneroRepo extends JpaRepository<FilmeGenero, Long> {
    List<Filme> findAllByGeneroId(Long generoId);
}
