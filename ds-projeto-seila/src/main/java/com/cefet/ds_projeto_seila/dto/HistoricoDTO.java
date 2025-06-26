package com.cefet.ds_projeto_seila.dto;

import com.cefet.ds_projeto_seila.entities.Historico;

import java.util.Date;

public class HistoricoDTO {

    private Long id;
    private Date data;
    private Long idFilme;
    private Long idCliente;

    public HistoricoDTO() {
    }

    public HistoricoDTO(Historico historico) {
        this.id = historico.getId();
        this.data = historico.getData();
        this.idFilme = historico.getFilme().getId();
        this.idCliente = historico.getCliente().getId();
    }

    public Long getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public Long getIdFilme() {
        return idFilme;
    }

    public Long getIdCliente() {
        return idCliente;
    }
}
