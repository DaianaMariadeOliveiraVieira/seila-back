package com.cefet.ds_projeto_seila.entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tbAssinatura")
public class Assinatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Date dataInicio;
    @Column(nullable = false)
    private boolean ativa;
    private Date dataFim;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "id_plano", nullable = false)
    private Plano plano;

    public Assinatura() {
    }

    public Assinatura(Long id, Date dataInicio, boolean ativa, Date dataFim, Cliente cliente, Plano plano) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.ativa = ativa;
        this.dataFim = dataFim;
        this.cliente = cliente;
        this.plano = plano;
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

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Assinatura that = (Assinatura) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDataInicio(), that.getDataInicio()) && Objects.equals(isAtiva(), that.isAtiva()) && Objects.equals(getDataFim(), that.getDataFim()) && Objects.equals(getCliente(), that.getCliente()) && Objects.equals(getPlano(), that.getPlano());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDataInicio(), isAtiva(), getDataFim(), getCliente(), getPlano());
    }
}
