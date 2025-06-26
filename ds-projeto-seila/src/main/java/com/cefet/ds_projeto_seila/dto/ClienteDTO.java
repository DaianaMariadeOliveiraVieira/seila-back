package com.cefet.ds_projeto_seila.dto;

import com.cefet.ds_projeto_seila.entities.Cliente;

public class ClienteDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String login;
    private String senha;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.login = cliente.getLogin();
        this.senha = cliente.getSenha();
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
}
