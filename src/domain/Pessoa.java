package domain;

import java.io.Serializable;

public abstract class Pessoa implements Serializable {
    private String cpf;
    private String nome;
    private String email;

    public Pessoa() {
        this.cpf = "";
        this.nome = "";
        this.email = "";
    }

    public Pessoa(String cpf, String nome, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
