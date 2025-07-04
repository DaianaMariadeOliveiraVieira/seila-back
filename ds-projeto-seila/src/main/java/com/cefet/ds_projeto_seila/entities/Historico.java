package com.cefet.ds_projeto_seila.entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_historico")
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date data;

    @ManyToOne
    @JoinColumn(name = "id_filme", nullable = false)
    private Filme filme;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    public Historico() {
    }

    public Historico(Long id, Date data, Filme filme, Cliente cliente) {
        this.id = id;
        this.data = data;
        this.filme = filme;
        this.cliente = cliente;
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

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Historico historico = (Historico) o;
        return Objects.equals(getId(), historico.getId()) && Objects.equals(getData(), historico.getData()) && Objects.equals(getFilme(), historico.getFilme()) && Objects.equals(getCliente(), historico.getCliente());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getData(), getFilme(), getCliente());
    }
}
