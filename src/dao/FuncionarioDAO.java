package dao;

import domain.Funcionario;

public class FuncionarioDAO extends GenericDAO<Funcionario> {
    
    public FuncionarioDAO() {
        super("src\\db\\funcionarios.txt", Funcionario.class);
    }

    @Override
    protected String getId(Funcionario funcionario) {
        return funcionario.getCpf();
    }

    @Override
    protected String toString(Funcionario func) {
        return String.format("%s;%s;%s;%s", func.getCpf(), func.getNome(), func.getEmail(), func.getSetor());
    }
}
