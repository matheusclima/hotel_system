package domain;

import java.util.ArrayList;

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

    public boolean cadastrar(Funcionario func) {
        // TODO
        return true;
    }

    public boolean editar(Funcionario func) {
        // TODO
        return true;
    }

    public Funcionario consultar(Funcionario func) {
        // TODO
        return func;
    }

    public ArrayList<Funcionario> listar(Funcionario func) {
        // TODO
        return new ArrayList<Funcionario>();
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}
