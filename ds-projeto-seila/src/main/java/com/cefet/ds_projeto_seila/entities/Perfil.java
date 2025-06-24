package com.cefet.ds_projeto_seila.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tbPerfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idCliente; 
    private Long idGenero;  

    
    public Perfil() {
    }

    
    public Perfil(Long id, Long idCliente, Long idGenero) {
        this.id = id;
        this.idCliente = idCliente;
        this.idGenero = idGenero;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Long idGenero) {
        this.idGenero = idGenero;
    }
}
