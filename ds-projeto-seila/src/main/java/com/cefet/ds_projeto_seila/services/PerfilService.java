package com.cefet.ds_projeto_seila.services;

import com.cefet.ds_projeto_seila.dto.PerfilDTO;
import com.cefet.ds_projeto_seila.entities.Cliente;
import com.cefet.ds_projeto_seila.entities.Genero;
import com.cefet.ds_projeto_seila.entities.Perfil;
import com.cefet.ds_projeto_seila.repositories.ClienteRepo;
import com.cefet.ds_projeto_seila.repositories.GeneroRepo;
import com.cefet.ds_projeto_seila.repositories.PerfilRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepo perfilRepo;

    @Autowired
    private ClienteRepo clienteRepo;

    @Autowired
    private GeneroRepo generoRepo;

    public List<PerfilDTO> findAll() {
        List<Perfil> perfis = perfilRepo.findAll();
        return perfis.stream().map(PerfilDTO::new).toList();
    }

    public PerfilDTO findById(Long id) {
        Perfil perfil = perfilRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Perfil não encontrado com ID: " + id));
        return new PerfilDTO(perfil);
    }

    public PerfilDTO insert(PerfilDTO dto) {
        Cliente cliente = clienteRepo.findById(dto.getIdCliente())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com ID: " + dto.getIdCliente()));
        Genero genero = generoRepo.findById(dto.getIdGenero())
                .orElseThrow(() -> new EntityNotFoundException("Gênero não encontrado com ID: " + dto.getIdGenero()));

        Perfil perfil = new Perfil(null, cliente, genero);
        Perfil saved = perfilRepo.save(perfil);
        return new PerfilDTO(saved);
    }

    public void delete(Long id) {
        if (!perfilRepo.existsById(id)) {
            throw new EntityNotFoundException("Perfil não encontrado com ID: " + id);
        }
        perfilRepo.deleteById(id);
    }

    public PerfilDTO update(Long id, PerfilDTO dto) {
        Perfil perfil = perfilRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Perfil não encontrado com ID: " + id));

        Cliente cliente = clienteRepo.findById(dto.getIdCliente())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com ID: " + dto.getIdCliente()));
        Genero genero = generoRepo.findById(dto.getIdGenero())
                .orElseThrow(() -> new EntityNotFoundException("Gênero não encontrado com ID: " + dto.getIdGenero()));

        perfil.setCliente(cliente);
        perfil.setGenero(genero);

        Perfil atualizado = perfilRepo.save(perfil);
        return new PerfilDTO(atualizado);
    }
}
