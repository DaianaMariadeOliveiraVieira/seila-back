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
import com.cefet.ds_projeto_seila.dto.PerfilDTO;
import com.cefet.ds_projeto_seila.services.FilmeService;
import com.cefet.ds_projeto_seila.services.PerfilService;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping("/{id}")
    public ResponseEntity<PerfilDTO> findById(@PathVariable Long id) {
        PerfilDTO perfilDTO = perfilService.findById(id);
        return ResponseEntity.ok(perfilDTO);
    }

    @GetMapping
    public ResponseEntity<List<PerfilDTO>> findAll() {
        List<PerfilDTO> perfis = perfilService.findAll();
        return ResponseEntity.ok(perfis);
    }

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<PerfilDTO>> findByClienteId(@PathVariable Long idCliente) {
        List<PerfilDTO> perfis = perfilService.findByClienteId(idCliente);
        return ResponseEntity.ok(perfis);
    }

    @PostMapping
    public ResponseEntity<PerfilDTO> create(@RequestBody PerfilDTO perfilDTO) {
        PerfilDTO novoPerfil = perfilService.insert(perfilDTO);
        return ResponseEntity.status(201).body(novoPerfil);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PerfilDTO> update(@PathVariable Long id, @RequestBody PerfilDTO perfilDTO) {
        PerfilDTO perfilAtualizado = perfilService.update(id, perfilDTO);
        return ResponseEntity.ok(perfilAtualizado);
    }

    @PutMapping("/cliente/{idCliente}")
    public ResponseEntity<List<PerfilDTO>> atualizarPerfisDoCliente(@PathVariable Long idCliente, @RequestBody List<PerfilDTO> novosPerfis) {
        List<PerfilDTO> perfisAtualizados = perfilService.updatePerfis(idCliente, novosPerfis);
        return ResponseEntity.ok(perfisAtualizados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        perfilService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
