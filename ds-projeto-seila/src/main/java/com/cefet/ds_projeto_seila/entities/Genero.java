package com.cefet.ds_projeto_seila.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tbGenero")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    
    public Genero() {
    }

    
    public Genero(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
