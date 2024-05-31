package interfaces;

import java.io.IOException;
import java.util.List;
import domain.Hospede;

public interface HospedeDAOInterface {
    public boolean cadastrar(Hospede hospede); 
    public boolean editar(Hospede hospede); 
    // public void consultar(Hospede hospede); 
    public List<Hospede> listar() throws IOException; 
}