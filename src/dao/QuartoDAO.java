package dao;

import domain.Quarto;

public class QuartoDAO extends GenericDAO<Quarto> {
    
    public QuartoDAO() {
        super("src\\db\\quartos.txt", Quarto.class);
    }

    @Override
    protected String getId(Quarto quarto) {
        return String.valueOf(quarto.getCodigo());
    }

    @Override
    protected String toString(Quarto quarto) {
        return String.format("%d;%d;%s", quarto.getCodigo(), quarto.getCategoria().getCodigo(), quarto.getStatus());
    }
}
