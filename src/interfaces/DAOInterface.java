package interfaces;

import java.io.IOException;
import java.util.ArrayList;

public interface DAOInterface<T> {
    public boolean cadastrar(T objetoT); 
    public boolean editar(T objetoT ); 
    public T consultar(T objetoT); 
    public ArrayList<T> listar() throws IOException;
    // public boolean excluir(Hospede hospede);
}
