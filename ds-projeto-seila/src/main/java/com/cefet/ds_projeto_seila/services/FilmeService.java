package com.cefet.ds_projeto_seila.services;

import com.cefet.ds_projeto_seila.dto.FilmeDTO;
import com.cefet.ds_projeto_seila.entities.Filme;
import com.cefet.ds_projeto_seila.repositories.FilmeRepo;
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
        if (filmeDTO.getNome() == null || filmeDTO.getNome().isEmpty()) {
            throw new IllegalArgumentException("O filme precisa ter nome.");
        }

        Filme filme = new Filme(filmeDTO.getId(), filmeDTO.getNome(), filmeDTO.getSinopse(), filmeDTO.getTags(), filmeDTO.getUrlVideo(), filmeDTO.getUrlImagem());
        Filme saved = filmeRepo.save(filme);
        return new FilmeDTO(saved);
    }

    public FilmeDTO update(Long id, FilmeDTO dto) {
        Filme filme = filmeRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Filme não encontrado com ID: " + id));

        if (dto.getNome() == null || dto.getNome().isEmpty()) {
            throw new IllegalArgumentException("O filme precisa ter nome.");
        }

        filme.setNome(dto.getNome());
        filme.setSinopse(dto.getSinopse());
        filme.setTags(dto.getTags());
        filme.setUrlVideo(dto.getUrlVideo());
        filme.setUrlImagem(dto.getUrlImagem());

        Filme updated = filmeRepo.save(filme);
        return new FilmeDTO(updated);
    }

    public void delete(Long id) {
        if (!filmeRepo.existsById(id)) {
            throw new EntityNotFoundException("Filme não encontrado com ID: " + id);
        }
        filmeRepo.deleteById(id);
    }
}
