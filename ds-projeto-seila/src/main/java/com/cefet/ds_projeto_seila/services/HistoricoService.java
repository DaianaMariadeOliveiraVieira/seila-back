package com.cefet.ds_projeto_seila.services;

import com.cefet.ds_projeto_seila.dto.HistoricoDTO;
import com.cefet.ds_projeto_seila.entities.Cliente;
import com.cefet.ds_projeto_seila.entities.Filme;
import com.cefet.ds_projeto_seila.entities.Historico;
import com.cefet.ds_projeto_seila.repositories.ClienteRepo;
import com.cefet.ds_projeto_seila.repositories.FilmeRepo;
import com.cefet.ds_projeto_seila.repositories.HistoricoRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricoService {

    @Autowired
    private HistoricoRepo historicoRepo;

    @Autowired
    private FilmeRepo filmeRepo;

    @Autowired
    private ClienteRepo clienteRepo;

    public List<HistoricoDTO> findAll() {
        List<Historico> historicos = historicoRepo.findAll();
        return historicos.stream().map(HistoricoDTO::new).toList();
    }

    public HistoricoDTO findById(Long id) {
        Historico historico = historicoRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Histórico não encontrado com ID: " + id));
        return new HistoricoDTO(historico);
    }

    public HistoricoDTO insert(HistoricoDTO dto) {
        Filme filme = filmeRepo.findById(dto.getIdFilme())
                .orElseThrow(() -> new EntityNotFoundException("Filme não encontrado com ID: " + dto.getIdFilme()));
        Cliente cliente = clienteRepo.findById(dto.getIdCliente())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com ID: " + dto.getIdCliente()));

        Historico historico = new Historico(null, dto.getData(), filme, cliente);
        Historico salvo = historicoRepo.save(historico);
        return new HistoricoDTO(salvo);
    }

    public HistoricoDTO update(Long id, HistoricoDTO dto) {
        Historico historico = historicoRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Histórico não encontrado com ID: " + id));

        Filme filme = filmeRepo.findById(dto.getIdFilme())
                .orElseThrow(() -> new EntityNotFoundException("Filme não encontrado com ID: " + dto.getIdFilme()));
        Cliente cliente = clienteRepo.findById(dto.getIdCliente())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com ID: " + dto.getIdCliente()));

        historico.setData(dto.getData());
        historico.setFilme(filme);
        historico.setCliente(cliente);

        Historico atualizado = historicoRepo.save(historico);
        return new HistoricoDTO(atualizado);
    }

    public void delete(Long id) {
        if (!historicoRepo.existsById(id)) {
            throw new EntityNotFoundException("Histórico não encontrado com ID: " + id);
        }
        historicoRepo.deleteById(id);
    }
}

