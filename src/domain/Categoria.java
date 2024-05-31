package domain;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

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
    
    public boolean cadastrar(Categoria cat) {
        try {
            FileOutputStream arq = new FileOutputStream("hospedes.ser");
            ObjectOutputStream obj = new ObjectOutputStream(arq);
            obj.writeObject(cat);
            obj.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean editar(Categoria cat) {
        // TODO
        return true;
    }

    public Categoria consultar(Categoria cat) {
        // TODO
        return cat;
    }

    public Categoria listar(Categoria cat) {
        try {
            FileInputStream arquivo = new FileInputStream("hospedes.ser"); 
            ObjectInputStream input = new ObjectInputStream(arquivo);
            Categoria categoria = (Categoria) input.readObject();
            input.close();
            System.out.printf( " %d\n %s\n %.2f\n",
                categoria.getCodigo(),
                categoria.getDescricao(),
                categoria.getValor());

            return categoria;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
            return null;
        }
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
