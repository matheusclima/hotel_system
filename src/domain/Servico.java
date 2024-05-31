package domain;
import java.util.ArrayList;

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

    public boolean cadastrar(Servico servico) {
        // TODO
        return true;
    }

    public boolean editar(Servico servico) {
        // TODO
        return true;
    }

    public Servico consultar(Servico servico) {
        // TODO
        return servico;
    }

    public ArrayList<Servico> listar(Servico servico) {
        // TODO
        return new ArrayList<Servico>();
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
