package domain;

public class Funcionario extends Pessoa {
    private String setor;

    public Funcionario() {
        super();
        this.setor = "";
    }

    public Funcionario(String cpf, String nome, String email, String setor) {
        super(cpf, nome, email);
        this.setor = setor;
    }
    
    public Funcionario(String[] attr) {
        super(attr);
        this.setor = attr[attr.length - 1];
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}
