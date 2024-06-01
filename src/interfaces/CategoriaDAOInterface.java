package interfaces;

import java.io.IOException;
import java.util.ArrayList;
import domain.Categoria;

public interface CategoriaDAOInterface {
    public boolean cadastrar(Categoria cat); 
    public boolean editar(Categoria cat); 
    public Categoria consultar(Categoria cat); 
    public ArrayList<Categoria> listar() throws IOException;
    public boolean salvarCategorias(ArrayList<Categoria> categorias);
    // public boolean excluir(Hospede hospede);
}
