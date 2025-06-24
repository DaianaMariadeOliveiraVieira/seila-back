package com.cefet.ds_projeto_seila.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tbFilme")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String sinopse;
    private String tags;
    private String urlVideo;
    private String urlImagem;


    public Filme() {
    }

    public Filme(Long id, String nome, String sinopse, String tags, String urlVideo, String urlImagem) {
        this.id = id;
        this.nome = nome;
        this.sinopse = sinopse;
        this.tags = tags;
        this.urlVideo = urlVideo;
        this.urlImagem = urlImagem;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
}
