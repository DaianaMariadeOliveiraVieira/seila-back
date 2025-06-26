package com.cefet.ds_projeto_seila.services;

import com.cefet.ds_projeto_seila.dto.FilmeDTO;
import com.cefet.ds_projeto_seila.dto.PlanoDTO;
import com.cefet.ds_projeto_seila.entities.Filme;
import com.cefet.ds_projeto_seila.entities.Plano;
import com.cefet.ds_projeto_seila.repositories.FilmeRepo;
import com.cefet.ds_projeto_seila.repositories.PlanoRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepo filmeRepo;

    public List<FilmeDTO> findAll() {
        List<Filme> filmes = filmeRepo.findAll();
        return filmes.stream().map(FilmeDTO::new).toList();
    }

    public FilmeDTO findById(Long id) {
        Filme filme = filmeRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Filme não encontrado com ID: " + id));
        return new FilmeDTO(filme);
    }

    public FilmeDTO insert(FilmeDTO filmeDTO) {
        Filme filme = new Filme(filmeDTO.getId(), filmeDTO.getNome(), filmeDTO.getSinopse(), filmeDTO.getTags(), filmeDTO.getUrlVideo(), filmeDTO.getUrlImagem());
        Filme saved = filmeRepo.save(filme);
        return new FilmeDTO(saved);
    }


}
