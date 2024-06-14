package interfaces;

import java.util.ArrayList;

public interface GenericDAOInterface<T> {
    public boolean cadastrar(T objetoT); 
    public boolean editar(T objetoT ); 
    public T consultar(T objetoT); 
    public ArrayList<T> listar();
}
