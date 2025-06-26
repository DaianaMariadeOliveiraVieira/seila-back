package com.cefet.ds_projeto_seila.services;

import com.cefet.ds_projeto_seila.dto.ClienteDTO;
import com.cefet.ds_projeto_seila.entities.Cliente;
import com.cefet.ds_projeto_seila.repositories.ClienteRepo;
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

    public ClienteDTO update(Long id, ClienteDTO dto) {
        Cliente cliente = clienteRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com ID: " + id));

        if (!cliente.getLogin().equals(dto.getLogin()) && clienteRepo.existsByLogin(dto.getLogin())) {
            throw new IllegalArgumentException("Login em uso");
        }
        if (!cliente.getCpf().equals(dto.getCpf()) && clienteRepo.existsByCpf(dto.getCpf())) {
            throw new IllegalArgumentException("CPF em uso");
        }

        cliente.setNome(dto.getNome());
        cliente.setCpf(dto.getCpf());
        cliente.setEmail(dto.getEmail());
        cliente.setLogin(dto.getLogin());
        cliente.setSenha(dto.getSenha());

        Cliente updated = clienteRepo.save(cliente);
        return new ClienteDTO(updated);
    }

    public void delete(Long id) {
        if (!clienteRepo.existsById(id)) {
            throw new EntityNotFoundException("Cliente não encontrado com ID: " + id);
        }
        clienteRepo.deleteById(id);
    }

    public boolean loginExiste(String login) {
        return clienteRepo.existsByLogin(login);
    }

    public boolean cpfExiste(String cpf) {
        return clienteRepo.existsByCpf(cpf);
    }
}
