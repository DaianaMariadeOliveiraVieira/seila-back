package com.cefet.ds_projeto_seila.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tbGenero")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Genero genero = (Genero) o;
        return Objects.equals(getId(), genero.getId()) && Objects.equals(getDescricao(), genero.getDescricao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescricao());
    }
}
