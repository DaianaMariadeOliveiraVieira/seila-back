package com.cefet.ds_projeto_seila.services;

import com.cefet.ds_projeto_seila.dto.FilmeDTO;
import com.cefet.ds_projeto_seila.dto.FilmeGeneroDTO;
import com.cefet.ds_projeto_seila.dto.GeneroDTO;
import com.cefet.ds_projeto_seila.entities.Filme;
import com.cefet.ds_projeto_seila.entities.FilmeGenero;
import com.cefet.ds_projeto_seila.entities.Genero;
import com.cefet.ds_projeto_seila.repositories.FilmeGeneroRepo;
import com.cefet.ds_projeto_seila.repositories.GeneroRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepo generoRepo;

    @Autowired
    private FilmeGeneroRepo filmeGeneroRepo;

    public List<GeneroDTO> findAll() {
        List<Genero> generos = generoRepo.findAll();
        return generos.stream().map(GeneroDTO::new).toList();
    }

    public GeneroDTO findById(Long id) {
        Genero genero = generoRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Gênero não encontrado com ID: " + id));
        return new GeneroDTO(genero);
    }

    public List<FilmeDTO> findFilmesByGeneroId(Long id) {
        List<FilmeGenero> filmesGeneros = filmeGeneroRepo.findAllByGeneroId(id);
        return filmesGeneros.stream()
                .map(FilmeGenero::getFilme) // Mapeia FilmeGenero para Filme
                .map(FilmeDTO::new)
                .toList();
    }

    public GeneroDTO insert(GeneroDTO generoDTO) {
        Genero genero = new Genero(generoDTO.getId(), generoDTO.getDescricao());
        Genero saved = generoRepo.save(genero);
        return new GeneroDTO(saved);
    }

    public GeneroDTO update(Long id, GeneroDTO dto) {
        Genero genero = generoRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Gênero não encontrado com ID: " + id));

        genero.setDescricao(dto.getDescricao());

        Genero updated = generoRepo.save(genero);
        return new GeneroDTO(updated);
    }

    public void delete(Long id) {
        if (!generoRepo.existsById(id)) {
            throw new EntityNotFoundException("Gênero não encontrado com ID: " + id);
        }
        generoRepo.deleteById(id);
    }
    public List<GeneroDTO> findGenerosByFilmeId(Long idFilme) {
    List<FilmeGenero> filmeGeneros = filmeGeneroRepo.findAllByFilmeId(idFilme);
    return filmeGeneros.stream()
            .map(FilmeGenero::getGenero)
            .map(GeneroDTO::new)
            .toList();
}

}
