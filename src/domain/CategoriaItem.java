package domain;

import dao.Gerenciador;

public class CategoriaItem {
    private Item item;
    private Categoria categoria;
    private int quantidade;

    public CategoriaItem() {
        this.item = new Item();
        this.categoria = new Categoria();
        this.quantidade = 0; 
    }

    public CategoriaItem(Item item, Categoria categoria, int quantidade) {
        this.item = item;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }

    public CategoriaItem(String attr[]) {
        this.item = new Item();
        this.item.setCodigo(Integer.parseInt(attr[0]));
        this.item = Gerenciador.itemDAO.consultar(this.item);
        this.categoria = new Categoria();
        this.categoria.setCodigo(Integer.parseInt(attr[1]));
        this.categoria = Gerenciador.categoriaDAO.consultar(this.categoria);
        this.quantidade = Integer.parseInt(attr[2]);
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }    
}
