package com.cefet.ds_projeto_seila.dto;

import com.cefet.ds_projeto_seila.entities.FilmeGenero;

public class FilmeGeneroDTO {

    private Long id;
    private Long idFilme;
    private Long idGenero;

    public FilmeGeneroDTO() {
    }

    public FilmeGeneroDTO(FilmeGenero filmeGenero) {
        this.id = filmeGenero.getId();
        this.idFilme = filmeGenero.getFilme().getId();
        this.idGenero = filmeGenero.getGenero().getId();
    }

    public Long getId() {
        return id;
    }

    public Long getIdFilme() {
        return idFilme;
    }

    public Long getIdGenero() {
        return idGenero;
    }
}
