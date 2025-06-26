package com.cefet.ds_projeto_seila.repositories;

import com.cefet.ds_projeto_seila.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepo extends JpaRepository<Cliente, Long> {
}
