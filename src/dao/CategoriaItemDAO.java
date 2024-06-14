package dao;

import domain.CategoriaItem;

public class CategoriaItemDAO extends GenericDAO<CategoriaItem> {
    
    public CategoriaItemDAO() {
        super("src\\db\\categoria_item.txt", CategoriaItem.class);
    }

    @Override
    protected String getId(CategoriaItem catItem) {
        return String.format("%d@%d", catItem.getItem().getCodigo(), catItem.getCategoria().getCodigo());
    }
    
    @Override
    protected String toString(CategoriaItem catItem) {
        return String.format("%d;%d;%d", catItem.getItem().getCodigo(), catItem.getCategoria().getCodigo(), 
                                        catItem.getQuantidade());

    }
}
