package com.cefet.ds_projeto_seila.dto;

import com.cefet.ds_projeto_seila.entities.Plano;

public class PlanoDTO {

    private Long id;
    private String descricao;
    private Double valor;

    public PlanoDTO() {
    }

    public PlanoDTO(Plano plano) {
        this.id = plano.getId();
        this.descricao = plano.getDescricao();
        this.valor = plano.getValor();
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValor() {
        return valor;
    }
}
