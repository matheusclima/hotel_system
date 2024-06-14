package dao;

import domain.Categoria;

public class CategoriaDAO extends GenericDAO<Categoria> {
    
    public CategoriaDAO() {
        super("src\\db\\categorias.txt", Categoria.class);
    }

    @Override
    protected String getId(Categoria cat) {
        return String.valueOf(cat.getCodigo());
    }

    @Override
    protected String toString(Categoria cat) {
        return String.format("%d;%s;%.2f", cat.getCodigo(), cat.getDescricao(), cat.getValor());
    }
}
