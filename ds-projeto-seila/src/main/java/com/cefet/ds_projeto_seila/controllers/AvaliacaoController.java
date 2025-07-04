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

import com.cefet.ds_projeto_seila.dto.AvaliacaoDTO;
import com.cefet.ds_projeto_seila.services.AvaliacaoService;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {
   
    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoDTO> findById(@PathVariable Long id) {
        AvaliacaoDTO avaliacaoDTO = avaliacaoService.findById(id);
        return ResponseEntity.ok(avaliacaoDTO);
    }

    @GetMapping
    public ResponseEntity<List<AvaliacaoDTO>> findAll() {
        List<AvaliacaoDTO> avaliacoes = avaliacaoService.findAll();
        return ResponseEntity.ok(avaliacoes);
    }

    @PostMapping
    public ResponseEntity<AvaliacaoDTO> create(@RequestBody AvaliacaoDTO avaliacaoDTO) {
        AvaliacaoDTO novaAvaliacao = avaliacaoService.insert(avaliacaoDTO);
        return ResponseEntity.status(201).body(novaAvaliacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvaliacaoDTO> update(@PathVariable Long id, @RequestBody AvaliacaoDTO avaliacaoDTO) {
        AvaliacaoDTO avaliacaoAtualizada = avaliacaoService.update(id, avaliacaoDTO);
        return ResponseEntity.ok(avaliacaoAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        avaliacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
