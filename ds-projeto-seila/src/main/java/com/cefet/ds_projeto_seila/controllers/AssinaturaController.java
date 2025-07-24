package com.cefet.ds_projeto_seila.controllers;

import java.util.List;

import com.cefet.ds_projeto_seila.entities.Assinatura;
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
import com.cefet.ds_projeto_seila.services.AssinaturaService;

@RestController
@RequestMapping("/assinaturas")
public class AssinaturaController {
    
    @Autowired
    private AssinaturaService assinaturaService;

    @GetMapping("/{id}")
    public ResponseEntity<AssinaturaDTO> findById(@PathVariable Long id) {
        AssinaturaDTO assinaturaDTO = assinaturaService.findById(id);
        return ResponseEntity.ok(assinaturaDTO);
    }

    @GetMapping
    public ResponseEntity<List<AssinaturaDTO>> findAll() {
        List<AssinaturaDTO> assinaturas = assinaturaService.findAll();
        return ResponseEntity.ok(assinaturas);
    }

    @GetMapping("/cliente/{clienteId}") // endpoint para buscar assinaturas de um cliente específico
    public ResponseEntity<List<AssinaturaDTO>> buscarPorIdDoCliente(@PathVariable Long clienteId) {
        List<AssinaturaDTO> assinaturas = assinaturaService.findByClienteId(clienteId);
        return ResponseEntity.ok(assinaturas);
    }

    @PostMapping
    public ResponseEntity<AssinaturaDTO> create(@RequestBody AssinaturaDTO assinaturaDTO) {
        AssinaturaDTO novaAssinatura = assinaturaService.insert(assinaturaDTO);
        return ResponseEntity.status(201).body(novaAssinatura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssinaturaDTO> update(@PathVariable Long id, @RequestBody AssinaturaDTO assinaturaDTO) {
        AssinaturaDTO assinaturaAtualizada = assinaturaService.update(id, assinaturaDTO);
        return ResponseEntity.ok(assinaturaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        assinaturaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
