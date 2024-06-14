package dao;

import domain.Item;

public class ItemDAO extends GenericDAO<Item> {
    
    public ItemDAO() {
        super("src\\db\\itens.txt", Item.class);
    }

    @Override
    protected String getId(Item item) {
        return Integer.toString(item.getCodigo());
    }

    @Override
    protected String toString(Item item) {
        return String.format("%d;%s;%.2f", item.getCodigo(), item.getDescricao(), item.getValor());
    }

}
