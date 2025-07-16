package com.cefet.ds_projeto_seila.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cefet.ds_projeto_seila.entities.Cliente;
import com.cefet.ds_projeto_seila.repositories.ClienteRepo;
import com.cefet.ds_projeto_seila.security.ClienteDetails;

@Service
public class ClienteDetailsService implements UserDetailsService {

    @Autowired
    private ClienteRepo clienteRepo;

    @Override
    public ClienteDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Cliente cliente = clienteRepo.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("Cliente não encontrado: " + login));
        return new ClienteDetails(cliente);
    }
}
