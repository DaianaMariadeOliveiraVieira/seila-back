package com.cefet.ds_projeto_seila.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_plano")
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private Double valor;

    public Plano() {
    }

    public Plano(Long id, String descricao, Double valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Plano plano = (Plano) o;
        return Objects.equals(getId(), plano.getId()) && Objects.equals(getDescricao(), plano.getDescricao()) && Objects.equals(getValor(), plano.getValor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescricao(), getValor());
    }
}
