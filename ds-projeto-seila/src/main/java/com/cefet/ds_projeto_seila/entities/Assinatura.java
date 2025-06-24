package com.cefet.ds_projeto_seila.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbAssinatura")
public class Assinatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dataInicio;
    private String situacao;
    private Date dataFim;

    private Long idCliente;  
    private Long idPlano;    

    public Assinatura() {
    }

    public Assinatura(Long id, Date dataInicio, String situacao, Date dataFim, Long idCliente, Long idPlano) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.situacao = situacao;
        this.dataFim = dataFim;
        this.idCliente = idCliente;
        this.idPlano = idPlano;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(Long idPlano) {
        this.idPlano = idPlano;
    }
}
