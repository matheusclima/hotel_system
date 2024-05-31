package domain;

import java.util.ArrayList;

public class Quarto {
    private int codigo;
    private Categoria categoria;
    private String status;

    public Quarto() {
        this.codigo = 0;
        this.categoria = null;
        this.status = "";
    }

    public Quarto(int codigo, Categoria categoria, String status) {
        this.codigo = codigo;
        this.categoria = categoria;
        this.status = status;
    }

    public boolean cadastrar(Quarto quarto) {
        // TODO
        return true;
    }

    public boolean editar(Quarto quarto) {
        // TODO
        return true;
    }

    public Quarto consultar(Quarto quarto) {
        // TODO
        return quarto;
    }

    public ArrayList<Quarto> listar(Quarto quarto) {
        // TODO
        return new ArrayList<Quarto>();
    }
}
