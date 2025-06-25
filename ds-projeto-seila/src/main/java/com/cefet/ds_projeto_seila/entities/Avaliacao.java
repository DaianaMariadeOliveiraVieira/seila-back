package com.cefet.ds_projeto_seila.entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tbAvaliacao")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date data;
    @Column(nullable = false)
    private String comentario;
    private Double nota;

    @ManyToOne
    @JoinColumn(name = "id_filme")
    private Filme filme;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Avaliacao() {
    }

    public Avaliacao(Long id, Date data, String comentario, Double nota, Filme filme, Cliente cliente) {
        this.id = id;
        this.data = data;
        this.comentario = comentario;
        this.nota = nota;
        this.filme = filme;
        this.cliente = cliente;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Avaliacao avaliacao = (Avaliacao) o;
        return Objects.equals(getId(), avaliacao.getId()) && Objects.equals(getData(), avaliacao.getData()) && Objects.equals(getComentario(), avaliacao.getComentario()) && Objects.equals(getNota(), avaliacao.getNota()) && Objects.equals(getFilme(), avaliacao.getFilme()) && Objects.equals(getCliente(), avaliacao.getCliente());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getData(), getComentario(), getNota(), getFilme(), getCliente());
    }
}
