package com.cefet.ds_projeto_seila.repositories;

import com.cefet.ds_projeto_seila.entities.Cliente;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepo extends JpaRepository<Cliente, Long> {

    boolean existsByCpf(String cpf);

    Optional<Cliente> findByLogin(String login);

    boolean existsByLogin(String login);
}
