package com.cefet.ds_projeto_seila.services;

import com.cefet.ds_projeto_seila.dto.AssinaturaDTO;
import com.cefet.ds_projeto_seila.entities.Assinatura;
import com.cefet.ds_projeto_seila.entities.Cliente;
import com.cefet.ds_projeto_seila.entities.Plano;
import com.cefet.ds_projeto_seila.repositories.AssinaturaRepo;
import com.cefet.ds_projeto_seila.repositories.ClienteRepo;
import com.cefet.ds_projeto_seila.repositories.PlanoRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssinaturaService {

    @Autowired
    private AssinaturaRepo assinaturaRepo;

    @Autowired
    private ClienteRepo clienteRepo;

    @Autowired
    private PlanoRepo planoRepo;

    public List<AssinaturaDTO> findAll() {
        List<Assinatura> list = assinaturaRepo.findAll();
        return list.stream().map(AssinaturaDTO::new).toList();
    }

    public AssinaturaDTO findById(Long id) {
        Assinatura assinatura = assinaturaRepo.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Assinatura não encontrada com ID: " + id));
        return new AssinaturaDTO(assinatura);
    }

    public AssinaturaDTO insert(AssinaturaDTO dto, Long idCliente, Long idPlano) {
        Cliente cliente = clienteRepo.findById(idCliente)
            .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com ID: " + idCliente));
        Plano plano = planoRepo.findById(idPlano)
            .orElseThrow(() -> new EntityNotFoundException("Plano não encontrado com ID: " + idPlano));

        Assinatura nova = new Assinatura(
            null,
            dto.getDataInicio(),
            dto.isAtiva(),
            dto.getDataFim(),
            cliente,
            plano
        );

        Assinatura saved = assinaturaRepo.save(nova);
        return new AssinaturaDTO(saved);
    }

    public void delete(Long id) {
        if (!assinaturaRepo.existsById(id)) {
            throw new EntityNotFoundException("Assinatura não encontrada com ID: " + id);
        }
        assinaturaRepo.deleteById(id);
    }

    public AssinaturaDTO update(Long id, AssinaturaDTO dto) {
        Assinatura assinatura = assinaturaRepo.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Assinatura não encontrada com ID: " + id));

        assinatura.setDataInicio(dto.getDataInicio());
        assinatura.setDataFim(dto.getDataFim());
        assinatura.setAtiva(dto.isAtiva());

        Assinatura atualizada = assinaturaRepo.save(assinatura);
        return new AssinaturaDTO(atualizada);
    }
}
