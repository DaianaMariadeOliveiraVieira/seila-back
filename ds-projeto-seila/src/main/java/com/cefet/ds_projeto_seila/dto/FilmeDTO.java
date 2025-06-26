package com.cefet.ds_projeto_seila.dto;

import com.cefet.ds_projeto_seila.entities.Filme;
import jakarta.persistence.Column;

public class FilmeDTO {

    private Long id;
    private String nome;
    private String sinopse;
    private String tags;
    private String urlVideo;
    private String urlImagem;

    public FilmeDTO() {
    }

    public FilmeDTO(Filme filme) {
        this.id = filme.getId();
        this.nome = filme.getNome();
        this.sinopse = filme.getSinopse();
        this.tags = filme.getTags();
        this.urlVideo = filme.getUrlVideo();
        this.urlImagem = filme.getUrlImagem();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSinopse() {
        return sinopse;
    }

    public String getTags() {
        return tags;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public String getUrlImagem() {
        return urlImagem;
    }
}
