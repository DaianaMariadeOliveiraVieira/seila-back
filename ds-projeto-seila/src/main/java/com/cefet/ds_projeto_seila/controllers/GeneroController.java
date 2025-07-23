package com.cefet.ds_projeto_seila.controllers;

import java.util.List;

import com.cefet.ds_projeto_seila.services.FilmeGeneroService;
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
import com.cefet.ds_projeto_seila.dto.GeneroDTO;
import com.cefet.ds_projeto_seila.entities.Genero;
import com.cefet.ds_projeto_seila.services.FilmeService;
import com.cefet.ds_projeto_seila.services.GeneroService;

@RestController
@RequestMapping("/generos")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @GetMapping("/{id}")
    public ResponseEntity<GeneroDTO> findById(@PathVariable Long id) {
        GeneroDTO genero = generoService.findById(id);
        return ResponseEntity.ok(genero);
    }

    @GetMapping
    public ResponseEntity<List<GeneroDTO>> findAll() {
        List<GeneroDTO> generos = generoService.findAll();
        return ResponseEntity.ok(generos);
    }

    @GetMapping("/{id}/filmes") // lista todos os filmes daquele genero
    public ResponseEntity<List<FilmeDTO>> findFilmesByGeneroId(@PathVariable Long id) {
        List<FilmeDTO> filmes = generoService.findFilmesByGeneroId(id);
        return ResponseEntity.ok(filmes);
    }

    @PostMapping
    public ResponseEntity<GeneroDTO> create(@RequestBody GeneroDTO generoDTO) {
        GeneroDTO novoGenero = generoService.insert(generoDTO);
        return ResponseEntity.status(201).body(novoGenero);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneroDTO> update(@PathVariable Long id, @RequestBody GeneroDTO generoDTO) {
        GeneroDTO generoAtualizado = generoService.update(id, generoDTO);
        return ResponseEntity.ok(generoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        generoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
