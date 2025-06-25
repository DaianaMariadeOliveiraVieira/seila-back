package com.cefet.ds_projeto_seila.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tbProdutoGenero")
public class ProdutoGenero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idFilme;   
    private Long idGenero; 

    public ProdutoGenero() {
    }

    public ProdutoGenero(Long id, Long idFilme, Long idGenero) {
        this.id = id;
        this.idFilme = idFilme;
        this.idGenero = idGenero;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Long idFilme) {
        this.idFilme = idFilme;
    }

    public Long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Long idGenero) {
        this.idGenero = idGenero;
    }
}
