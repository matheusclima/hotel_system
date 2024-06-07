package domain;

public class Item extends Generic {
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

    public Item(String[] attr) {
        this.codigo = Integer.parseInt(attr[0]);
        this.descricao = attr[1];
        this.valor = Double.parseDouble(attr[2].replace(",", "."));
    }

    @Override
    public String getId() {
        return Integer.toString(this.codigo);
    }

    @Override
    public String toString() {
        return String.format("%d;%s;%.2f", this.codigo, this.descricao, this.valor);
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
