package com.cefet.ds_projeto_seila.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cefet.ds_projeto_seila.dto.FilmeDTO;
import com.cefet.ds_projeto_seila.dto.FilmeGeneroDTO;
import com.cefet.ds_projeto_seila.services.FilmeGeneroService;
import com.cefet.ds_projeto_seila.services.FilmeService;

@RestController
@RequestMapping("/filmes-generos")
public class FilmeGeneroController {

    @Autowired
    private FilmeGeneroService filmeGeneroService;

    @GetMapping("/{id}")
    public ResponseEntity<FilmeGeneroDTO> findById(@PathVariable Long id) {
        FilmeGeneroDTO filmeGeneroDTO = filmeGeneroService.findById(id);
        return ResponseEntity.ok(filmeGeneroDTO);
    }

    @GetMapping
    public ResponseEntity<List<FilmeGeneroDTO>> findAll() {
        List<FilmeGeneroDTO> filmesGeneros = filmeGeneroService.findAll();
        return ResponseEntity.ok(filmesGeneros);
    }

    @PostMapping
    public ResponseEntity<FilmeGeneroDTO> create(@RequestBody FilmeGeneroDTO filmeGeneroDTO) {
        FilmeGeneroDTO novoFilmeGenero = filmeGeneroService.insert(filmeGeneroDTO);
        return ResponseEntity.status(201).body(novoFilmeGenero);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmeGeneroDTO> update(@PathVariable Long id, @RequestBody FilmeGeneroDTO filmeGeneroDTO) {
        FilmeGeneroDTO filmeGeneroAtualizado = filmeGeneroService.update(id, filmeGeneroDTO);
        return ResponseEntity.ok(filmeGeneroAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        filmeGeneroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
