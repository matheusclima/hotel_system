package interfaces;

import java.io.IOException;
import java.util.ArrayList;
import domain.Hospede;

public interface HospedeDAOInterfaceExemplo {
    public boolean cadastrar(Hospede hospede); 
    public boolean editar(Hospede hospede); 
    public Hospede consultar(Hospede hospede); 
    public ArrayList<Hospede> listar() throws IOException;
    // public boolean salvarHospedes(ArrayList<Hospede> hospedes);
    // public boolean excluir(Hospede hospede);
}
