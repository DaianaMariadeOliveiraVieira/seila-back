package com.cefet.ds_projeto_seila.dto;

import com.cefet.ds_projeto_seila.entities.Genero;

public class GeneroDTO {

    private Long id;
    private String descricao;

    public GeneroDTO() {
    }

    public GeneroDTO(Genero genero) {
        this.id = genero.getId();
        this.descricao = genero.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}
