package com.cefet.ds_projeto_seila.dto;

import com.cefet.ds_projeto_seila.entities.Perfil;

public class PerfilDTO {

    private Long id;
    private boolean gostaDoGenero;
    private Long idCliente;
    private Long idGenero;

    public PerfilDTO() {
    }

    public PerfilDTO(Perfil perfil) {
        this.id = perfil.getId();
        this.gostaDoGenero = perfil.isGostaDoGenero();
        this.idCliente = perfil.getCliente().getId();
        this.idGenero = perfil.getGenero().getId();
    }

    public Long getId() {
        return id;
    }

    public boolean isGostaDoGenero() {
        return gostaDoGenero;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public Long getIdGenero() {
        return idGenero;
    }
}
