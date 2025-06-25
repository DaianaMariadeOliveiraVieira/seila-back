package com.cefet.ds_projeto_seila.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbAvaliacao")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date data;
    private String comentario;
    private Double nota;

    private Long idFilme;    
    private Long idCliente;  

    public Avaliacao() {
    }

    public Avaliacao(Long id, Date data, String comentario, Double nota, Long idFilme, Long idCliente) {
        this.id = id;
        this.data = data;
        this.comentario = comentario;
        this.nota = nota;
        this.idFilme = idFilme;
        this.idCliente = idCliente;
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

    public Long getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Long idFilme) {
        this.idFilme = idFilme;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
}
