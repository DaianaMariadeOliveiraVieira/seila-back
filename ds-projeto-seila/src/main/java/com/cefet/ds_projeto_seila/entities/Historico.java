package com.cefet.ds_projeto_seila.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbHistorico")
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date data;

    private Long idFilme;    
    private Long idCliente; 

    public Historico() {
    }

    public Historico(Long id, Date data, Long idFilme, Long idCliente) {
        this.id = id;
        this.data = data;
        this.idFilme = idFilme;
        this.idCliente = idCliente;
    }



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
