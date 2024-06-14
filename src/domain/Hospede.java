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

    public Hospede(String[] attr) {
        super(attr);
        this.enderecoCompleto = attr[attr.length-1];
    }

    public String getEnderecoCompleto() {
        return enderecoCompleto;
    }

    public void setEnderecoCompleto(String enderecoCompleto) {
        this.enderecoCompleto = enderecoCompleto;
    }
}
