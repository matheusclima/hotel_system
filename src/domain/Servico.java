package domain;

public class Servico {
    private int codigo;
    private String descricao;
    private double valor;

    public Servico() {
        this.codigo = 0;
        this.descricao = "";
        this.valor = 0;
    }

    public Servico(int codigo, String descricao, double valor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Servico(String[] attr) {
        this.codigo = Integer.parseInt(attr[0]);
        this.descricao = attr[1];
        this.valor = Double.parseDouble(attr[2].replace(",", "."));
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
