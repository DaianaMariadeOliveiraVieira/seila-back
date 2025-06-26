package com.cefet.ds_projeto_seila.dto;

import com.cefet.ds_projeto_seila.entities.Avaliacao;

import java.util.Date;

public class AvaliacaoDTO {

    private Long id;
    private Date data;
    private String comentario;
    private Double nota;
    private Long idFilme;
    private Long idCliente;

    public AvaliacaoDTO() {
    }

    public AvaliacaoDTO(Avaliacao avaliacao) {
        this.id = avaliacao.getId();
        this.data = avaliacao.getData();
        this.comentario = avaliacao.getComentario();
        this.nota = avaliacao.getNota();
        this.idFilme = avaliacao.getFilme().getId();
        this.idCliente = avaliacao.getCliente().getId();
    }

    public Long getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public String getComentario() {
        return comentario;
    }

    public Double getNota() {
        return nota;
    }

    public Long getIdFilme() {
        return idFilme;
    }

    public Long getIdCliente() {
        return idCliente;
    }
}
