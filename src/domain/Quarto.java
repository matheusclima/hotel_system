package domain;

import dao.Gerenciador;

public class Quarto {
    private int codigo;
    private Categoria categoria;
    private String status;

    public Quarto() {
        this.codigo = 0;
        this.categoria = new Categoria();
        this.status = "";
    }

    public Quarto(int codigo, Categoria categoria, String status) {
        this.codigo = codigo;
        this.categoria = categoria;
        this.status = status;
    }

    public Quarto(String[] attr) {
        this.codigo = Integer.parseInt(attr[0]);
        this.categoria = new Categoria();
        this.categoria.setCodigo(Integer.parseInt(attr[1]));
        this.categoria = Gerenciador.categoriaDAO.consultar(this.categoria);
        this.status = attr[2];
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }    
}
