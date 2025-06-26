package com.cefet.ds_projeto_seila.services;

import com.cefet.ds_projeto_seila.dto.PlanoDTO;
import com.cefet.ds_projeto_seila.entities.Plano;
import com.cefet.ds_projeto_seila.repositories.PlanoRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoService {

    @Autowired
    private PlanoRepo planoRepo;

    public List<PlanoDTO> findAll() {
        List<Plano> planos = planoRepo.findAll();
        return planos.stream().map(PlanoDTO::new).toList();
    }

    public PlanoDTO findById(Long id) {
        Plano plano = planoRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Plano não encontrado com ID: " + id));
        return new PlanoDTO(plano);
    }

    public PlanoDTO insert(PlanoDTO planoDTO) {
        if (planoDTO.getValor() <= 0)
            throw new IllegalArgumentException("O valor do plano deve ser um número positivo");

        if (planoRepo.existsByDescricao(planoDTO.getDescricao()))
            throw new IllegalArgumentException("Já existe um plano com a descrição: " + planoDTO.getDescricao());

        Plano plano = new Plano(planoDTO.getId(), planoDTO.getDescricao(), planoDTO.getValor());
        Plano saved = planoRepo.save(plano);
        return new PlanoDTO(saved);
    }

    public PlanoDTO update(Long id, PlanoDTO dto) {
        Plano plano = planoRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Plano não encontrado com ID: " + id));

        if (dto.getValor() <= 0)
            throw new IllegalArgumentException("O valor do plano deve ser um número positivo");

        // verificar se a descrição já existe para outro plano ....
        if (planoRepo.existsByDescricao(dto.getDescricao()) && !plano.getDescricao().equals(dto.getDescricao())) {
            throw new IllegalArgumentException("Já existe um plano com a descrição: " + dto.getDescricao());
        }

        plano.setDescricao(dto.getDescricao());
        plano.setValor(dto.getValor());

        Plano updated = planoRepo.save(plano);
        return new PlanoDTO(updated);
    }

    public void delete(Long id) {
        if (!planoRepo.existsById(id)) {
            throw new EntityNotFoundException("Plano não encontrado com ID: " + id);
        }
        planoRepo.deleteById(id);
    }
}
