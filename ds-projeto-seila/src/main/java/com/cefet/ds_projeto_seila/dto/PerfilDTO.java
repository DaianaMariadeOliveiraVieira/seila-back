package com.cefet.ds_projeto_seila.dto;

import com.cefet.ds_projeto_seila.entities.Perfil;

public class PerfilDTO {

    private Long id;
    private Long idCliente;
    private Long idGenero;

    public PerfilDTO() {
    }

    public PerfilDTO(Perfil perfil) {
        this.id = perfil.getId();
        this.idCliente = perfil.getCliente().getId();
        this.idGenero = perfil.getGenero().getId();
    }

    public Long getId() {
        return id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public Long getIdGenero() {
        return idGenero;
    }
}
