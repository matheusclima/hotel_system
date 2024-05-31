package domain;

import java.util.ArrayList;

public class Item {
    private int codigo;
    private String descricao;
    private double valor;

    public Item() {
        this.codigo = 0;
        this.descricao = "";
        this.valor = 0;
    }

    public Item(int codigo, String descricao, double valor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
    }

     public boolean cadastrar(Item item) {
        // TODO
        return true;
    }

    public boolean editar(Item item) {
        // TODO
        return true;
    }

    public Item consultar(Item item) {
        // TODO
        return item;
    }

    public ArrayList<Item> listar(Item item) {
        // TODO
        return new ArrayList<Item>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    
}
