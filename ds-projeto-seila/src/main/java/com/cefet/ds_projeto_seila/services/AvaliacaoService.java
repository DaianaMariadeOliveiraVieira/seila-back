package com.cefet.ds_projeto_seila.services;

import com.cefet.ds_projeto_seila.dto.AvaliacaoDTO;
import com.cefet.ds_projeto_seila.entities.Avaliacao;
import com.cefet.ds_projeto_seila.entities.Cliente;
import com.cefet.ds_projeto_seila.entities.Filme;
import com.cefet.ds_projeto_seila.repositories.AvaliacaoRepo;
import com.cefet.ds_projeto_seila.repositories.ClienteRepo;
import com.cefet.ds_projeto_seila.repositories.FilmeRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepo avaliacaoRepo;

    @Autowired
    private FilmeRepo filmeRepo;

    @Autowired
    private ClienteRepo clienteRepo;

    public List<AvaliacaoDTO> findAll() {
        List<Avaliacao> list = avaliacaoRepo.findAll();
        return list.stream().map(AvaliacaoDTO::new).toList();
    }

    public AvaliacaoDTO findById(Long id) {
        Avaliacao avaliacao = avaliacaoRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Avaliação não encontrada com ID: " + id));
        return new AvaliacaoDTO(avaliacao);
    }

    public AvaliacaoDTO insert(AvaliacaoDTO dto) {
        Filme filme = filmeRepo.findById(dto.getIdFilme())
                .orElseThrow(() -> new EntityNotFoundException("Filme não encontrado com ID: " + dto.getIdFilme()));
        Cliente cliente = clienteRepo.findById(dto.getIdCliente())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com ID: " + dto.getIdCliente()));

        if (dto.getNota() < 0 || dto.getNota() > 10) {
            throw new IllegalArgumentException("Nota deve ser entre 0 e 10");
        }

        Avaliacao avaliacao = new Avaliacao(null, dto.getData(), dto.getComentario(), dto.getNota(), filme, cliente);
        Avaliacao salvo = avaliacaoRepo.save(avaliacao);
        return new AvaliacaoDTO(salvo);
    }

    public AvaliacaoDTO update(Long id, AvaliacaoDTO dto) {
        Avaliacao avaliacao = avaliacaoRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Avaliação não encontrada com ID: " + id));

        Filme filme = filmeRepo.findById(dto.getIdFilme())
                .orElseThrow(() -> new EntityNotFoundException("Filme não encontrado com ID: " + dto.getIdFilme()));
        Cliente cliente = clienteRepo.findById(dto.getIdCliente())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com ID: " + dto.getIdCliente()));

        if (dto.getNota() < 0 || dto.getNota() > 10) {
            throw new IllegalArgumentException("Nota deve ser entre 0 e 10");
        }
        avaliacao.setData(dto.getData());
        avaliacao.setComentario(dto.getComentario());
        avaliacao.setNota(dto.getNota());
        avaliacao.setFilme(filme);
        avaliacao.setCliente(cliente);

        Avaliacao atualizado = avaliacaoRepo.save(avaliacao);
        return new AvaliacaoDTO(atualizado);
    }

    public void delete(Long id) {
        if (!avaliacaoRepo.existsById(id)) {
            throw new EntityNotFoundException("Avaliação não encontrada com ID: " + id);
        }
        avaliacaoRepo.deleteById(id);
    }
}
