package com.cefet.ds_projeto_seila.dto;

import com.cefet.ds_projeto_seila.entities.Assinatura;

import java.util.Date;
import java.util.Objects;

public class AssinaturaDTO {

    private Long id;
    private Date dataInicio;
    private Date dataFim;
    private boolean ativa;
    private Long idCliente;
    private Long idPlano;

    public AssinaturaDTO() {
    }

    public AssinaturaDTO(Assinatura assinatura) {
        this.id = assinatura.getId();
        this.dataInicio = assinatura.getDataInicio();
        this.dataFim = assinatura.getDataFim();
        this.ativa = assinatura.isAtiva();
        this.idCliente = assinatura.getCliente().getId();
        this.idPlano = assinatura.getPlano().getId();
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

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AssinaturaDTO that = (AssinaturaDTO) o;
        return isAtiva() == that.isAtiva() && Objects.equals(getId(), that.getId()) && Objects.equals(getDataInicio(), that.getDataInicio()) && Objects.equals(getDataFim(), that.getDataFim());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDataInicio(), getDataFim(), isAtiva());
    }
}
