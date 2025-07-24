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
import com.cefet.ds_projeto_seila.dto.HistoricoDTO;
import com.cefet.ds_projeto_seila.services.FilmeService;
import com.cefet.ds_projeto_seila.services.HistoricoService;

@RestController
@RequestMapping("/historico")
public class HistoricoController {

    @Autowired
    private HistoricoService historicoService;

    @GetMapping("/{id}")
    public ResponseEntity<HistoricoDTO> findById(@PathVariable Long id) {
        HistoricoDTO historicoDTO = historicoService.findById(id);
        return ResponseEntity.ok(historicoDTO);
    }

    @GetMapping
    public ResponseEntity<List<HistoricoDTO>> findAll() {
        List<HistoricoDTO> historicos = historicoService.findAll();
        return ResponseEntity.ok(historicos);
    }

    @GetMapping("/cliente/{clienteId}") // endpoint para buscar histórico de um cliente específico
    public ResponseEntity<List<HistoricoDTO>> buscarPorIdDoCliente(@PathVariable Long clienteId) {
        List<HistoricoDTO> historicos = historicoService.findByClienteId(clienteId);
        return ResponseEntity.ok(historicos);
    }

    @PostMapping
    public ResponseEntity<HistoricoDTO> create(@RequestBody HistoricoDTO historicoDTO) {
        HistoricoDTO novoHistorico = historicoService.insert(historicoDTO);
        return ResponseEntity.status(201).body(novoHistorico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoricoDTO> update(@PathVariable Long id, @RequestBody HistoricoDTO historicoDTO) {
        HistoricoDTO historicoAtualizado = historicoService.update(id, historicoDTO);
        return ResponseEntity.ok(historicoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        historicoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
