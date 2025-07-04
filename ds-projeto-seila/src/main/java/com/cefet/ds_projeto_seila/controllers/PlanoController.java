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
import com.cefet.ds_projeto_seila.dto.PlanoDTO;
import com.cefet.ds_projeto_seila.entities.Plano;
import com.cefet.ds_projeto_seila.services.FilmeService;
import com.cefet.ds_projeto_seila.services.PlanoService;

@RestController
@RequestMapping("/planos")
public class PlanoController {

    @Autowired
    private PlanoService planoService;

    @GetMapping("/{id}")
    public ResponseEntity<PlanoDTO> findById(@PathVariable Long id) {
        PlanoDTO planoDTO = planoService.findById(id);
        return ResponseEntity.ok(planoDTO);
    }

    @GetMapping
    public ResponseEntity<List<PlanoDTO>> findAll() {
        List<PlanoDTO> planos = planoService.findAll();
        return ResponseEntity.ok(planos);
    }

    @PostMapping
    public ResponseEntity<PlanoDTO> create(@RequestBody PlanoDTO planoDTO) {
        PlanoDTO novoPlano = planoService.insert(planoDTO);
        return ResponseEntity.status(201).body(novoPlano);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanoDTO> update(@PathVariable Long id, @RequestBody PlanoDTO planoDTO) {
        PlanoDTO planoAtualizado = planoService.update(id, planoDTO);
        return ResponseEntity.ok(planoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        planoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
