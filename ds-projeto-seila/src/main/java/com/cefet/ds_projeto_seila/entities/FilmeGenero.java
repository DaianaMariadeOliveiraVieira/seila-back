package com.cefet.ds_projeto_seila.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_filme_genero")
public class FilmeGenero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_filme", nullable = false)
    private Filme filme;

    @ManyToOne
    @JoinColumn(name = "id_genero", nullable = false)
    private Genero genero;

    public FilmeGenero() {
    }

    public FilmeGenero(Long id, Filme filme, Genero genero) {
        this.id = id;
        this.filme = filme;
        this.genero = genero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FilmeGenero that = (FilmeGenero) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(filme, that.filme) && Objects.equals(genero, that.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), filme, genero);
    }
}
