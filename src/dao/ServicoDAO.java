package dao;

import domain.Servico;

public class ServicoDAO extends GenericDAO<Servico> {
    
    public ServicoDAO() {
        super("src\\db\\servicos.txt", Servico.class);
    }

    @Override
    protected String getId(Servico servico) {
        return Integer.toString(servico.getCodigo());
    }

    @Override
    protected String toString(Servico servico) {
        return String.format("%d;%s;%.2f", servico.getCodigo(), servico.getDescricao(), servico.getValor());
    }
}
