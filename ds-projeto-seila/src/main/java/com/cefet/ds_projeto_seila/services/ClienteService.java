package com.cefet.ds_projeto_seila.services;

import com.cefet.ds_projeto_seila.dto.ClienteDTO;
import com.cefet.ds_projeto_seila.dto.PlanoDTO;
import com.cefet.ds_projeto_seila.entities.Cliente;
import com.cefet.ds_projeto_seila.entities.Plano;
import com.cefet.ds_projeto_seila.repositories.ClienteRepo;
import com.cefet.ds_projeto_seila.repositories.PlanoRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepo clienteRepo;

    public List<ClienteDTO> findAll() {
        List<Cliente> clientes = clienteRepo.findAll();
        return clientes.stream().map(ClienteDTO::new).toList();
    }

    public ClienteDTO findById(Long id) {
        Cliente cliente = clienteRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com ID: " + id));
        return new ClienteDTO(cliente);
    }

    public ClienteDTO insert(ClienteDTO clienteDTO) {
        if (clienteRepo.existsByLogin(clienteDTO.getLogin()))
            throw new IllegalArgumentException("Login em uso");
        if (clienteRepo.existsByCpf(clienteDTO.getCpf()))
            throw new IllegalArgumentException("CPF em uso");

        Cliente cliente = new Cliente(clienteDTO.getId(), clienteDTO.getNome(), clienteDTO.getCpf(), clienteDTO.getEmail(), clienteDTO.getLogin(), clienteDTO.getSenha());
        Cliente saved = clienteRepo.save(cliente);
        return new ClienteDTO(saved);
    }

    public boolean loginExiste(String login) {
        return clienteRepo.existsByLogin(login);
    }

    public boolean cpfExiste(String cpf) {
        return clienteRepo.existsByCpf(cpf);
    }
}
