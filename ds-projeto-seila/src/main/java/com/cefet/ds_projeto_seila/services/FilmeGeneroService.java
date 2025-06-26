package com.cefet.ds_projeto_seila.services;

import com.cefet.ds_projeto_seila.dto.FilmeGeneroDTO;
import com.cefet.ds_projeto_seila.entities.Filme;
import com.cefet.ds_projeto_seila.entities.FilmeGenero;
import com.cefet.ds_projeto_seila.entities.Genero;
import com.cefet.ds_projeto_seila.repositories.FilmeGeneroRepo;
import com.cefet.ds_projeto_seila.repositories.FilmeRepo;
import com.cefet.ds_projeto_seila.repositories.GeneroRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeGeneroService {

    @Autowired
    private FilmeGeneroRepo filmeGeneroRepo;

    @Autowired
    private FilmeRepo filmeRepo;

    @Autowired
    private GeneroRepo generoRepo;

    public List<FilmeGeneroDTO> findAll() {
        List<FilmeGenero> list = filmeGeneroRepo.findAll();
        return list.stream().map(FilmeGeneroDTO::new).toList();
    }

    public FilmeGeneroDTO findById(Long id) {
        FilmeGenero fg = filmeGeneroRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("FilmeGenero não encontrado com ID: " + id));
        return new FilmeGeneroDTO(fg);
    }

    public FilmeGeneroDTO insert(FilmeGeneroDTO dto) {
        Filme filme = filmeRepo.findById(dto.getIdFilme())
                .orElseThrow(() -> new EntityNotFoundException("Filme não encontrado com ID: " + dto.getIdFilme()));
        Genero genero = generoRepo.findById(dto.getIdGenero())
                .orElseThrow(() -> new EntityNotFoundException("Gênero não encontrado com ID: " + dto.getIdGenero()));

        FilmeGenero entidade = new FilmeGenero(null, filme, genero);
        FilmeGenero salvo = filmeGeneroRepo.save(entidade);
        return new FilmeGeneroDTO(salvo);
    }

    public FilmeGeneroDTO update(Long id, FilmeGeneroDTO dto) {
        FilmeGenero entidade = filmeGeneroRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("FilmeGenero não encontrado com ID: " + id));

        Filme filme = filmeRepo.findById(dto.getIdFilme())
                .orElseThrow(() -> new EntityNotFoundException("Filme não encontrado com ID: " + dto.getIdFilme()));
        Genero genero = generoRepo.findById(dto.getIdGenero())
                .orElseThrow(() -> new EntityNotFoundException("Gênero não encontrado com ID: " + dto.getIdGenero()));

        entidade.setFilme(filme);
        entidade.setGenero(genero);

        FilmeGenero atualizado = filmeGeneroRepo.save(entidade);
        return new FilmeGeneroDTO(atualizado);
    }

    public void delete(Long id) {
        if (!filmeGeneroRepo.existsById(id)) {
            throw new EntityNotFoundException("FilmeGenero não encontrado com ID: " + id);
        }
        filmeGeneroRepo.deleteById(id);
    }
}
