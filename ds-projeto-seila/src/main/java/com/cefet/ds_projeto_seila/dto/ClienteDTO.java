package com.cefet.ds_projeto_seila.dto;

import com.cefet.ds_projeto_seila.entities.Cliente;
import com.cefet.ds_projeto_seila.entities.NivelAcesso;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClienteDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String email;

    private String login;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;
    private NivelAcesso nivelAcesso;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.login = cliente.getLogin();
        this.senha = cliente.getSenha();
        this.nivelAcesso = cliente.getNivelAcesso();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public NivelAcesso getNivelAcesso() {
        return nivelAcesso;
    }
}
