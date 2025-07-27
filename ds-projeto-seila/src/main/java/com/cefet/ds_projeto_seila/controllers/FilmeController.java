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

import com.cefet.ds_projeto_seila.dto.AssinaturaDTO;
import com.cefet.ds_projeto_seila.dto.FilmeDTO;
import com.cefet.ds_projeto_seila.entities.Filme;
import com.cefet.ds_projeto_seila.services.AssinaturaService;
import com.cefet.ds_projeto_seila.services.FilmeService;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
   
    @Autowired
    private FilmeService filmeService;

    @GetMapping("/{id}")
    public ResponseEntity<FilmeDTO> findById(@PathVariable Long id) {
        FilmeDTO filmeDTO = filmeService.findById(id);
        return ResponseEntity.ok(filmeDTO);
    }

    @GetMapping
    public ResponseEntity<List<FilmeDTO>> findAll() {
        List<FilmeDTO> filmes = filmeService.findAll();
        return ResponseEntity.ok(filmes);
    }

    @PostMapping
    public ResponseEntity<FilmeDTO> create(@RequestBody FilmeDTO filmeDTO) {
        FilmeDTO novoFilme = filmeService.insert(filmeDTO);
        return ResponseEntity.status(201).body(novoFilme);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmeDTO> update(@PathVariable Long id, @RequestBody FilmeDTO filmeDTO) {
        FilmeDTO filmeAtualizado = filmeService.update(id, filmeDTO);
        return ResponseEntity.ok(filmeAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        filmeService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
