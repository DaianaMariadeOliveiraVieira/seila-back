package com.cefet.ds_projeto_seila.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tbPerfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean gostaDoGenero;
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_genero", nullable = false)
    private Genero genero;

    public Perfil() {
    }

    public Perfil(Long id, Cliente cliente, Genero genero, boolean gostaDoGenero) {
        this.id = id;
        this.cliente = cliente;
        this.genero = genero;
        this.gostaDoGenero = gostaDoGenero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public boolean isGostaDoGenero() {
        return gostaDoGenero;
    }

    public void setGostaDoGenero(boolean gostaDoGenero) {
        this.gostaDoGenero = gostaDoGenero;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Perfil perfil = (Perfil) o;
        return Objects.equals(getId(), perfil.getId()) && Objects.equals(getCliente(), perfil.getCliente()) && Objects.equals(getGenero(), perfil.getGenero());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCliente(), getGenero());
    }
}
