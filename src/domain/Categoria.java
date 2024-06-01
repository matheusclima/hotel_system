package domain;

import java.io.Serializable;

public class Categoria implements Serializable {
    private int codigo;
    private String descricao;
    private double valor;
    
    public Categoria() {
        this.codigo = 0;
        this.descricao = "";
        this.valor = 0;
    }

    public Categoria(int codigo, String descricao, double valor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format("%d;%s;%f", this.codigo, this.descricao, this.valor);
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
