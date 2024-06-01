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

    @Override
    public String toString() {
        return String.format("%d;%d;%s", this.codigo, this.categoria.getCodigo(), this.status);
    }
}
