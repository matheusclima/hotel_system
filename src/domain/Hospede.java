package domain;

public class Hospede extends Pessoa {
    private String enderecoCompleto;

    public Hospede() {
        super();
        this.enderecoCompleto = "";
    }

    public Hospede(String cpf, String nome, String email, String enderecoCompleto) {
        super(cpf, nome, email);
        this.enderecoCompleto = enderecoCompleto;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s", this.getCpf(), this.getNome(), this.getEmail(), this.enderecoCompleto);
    }

    public String getEnderecoCompleto() {
        return enderecoCompleto;
    }

    public void setEnderecoCompleto(String enderecoCompleto) {
        this.enderecoCompleto = enderecoCompleto;
    }

}
