package com.cefet.ds_projeto_seila.repositories;

import com.cefet.ds_projeto_seila.entities.Assinatura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssinaturaRepo extends JpaRepository<Assinatura, Long> {
    List<Assinatura> findByClienteId(Long clienteId);
}
