import java.util.ArrayList;

import dao.HospedeDAO;
import domain.*;

public class App {
    public static void main(String[] args) throws Exception {
        HospedeDAO manager = new HospedeDAO();

        // Hospede hospede1 = new Hospede("123", "Jose", "jose@email.com", "Rua das Flores, 120");
        // manager.cadastrar(hospede1);

        // Hospede hospede2 = new Hospede("1234", "Maria", "maria@email.com", "asadoime");
        // manager.cadastrar(hospede2);

        Hospede hospede3 = new Hospede("12345", "Joao", "joao@email.com", "Rua das Graças, 51");
        // manager.cadastrar(hospede3);

        ArrayList<Hospede> hospedes = manager.listar();
        for(Hospede h: hospedes) {
            System.out.println(h.toString());
        }
        System.out.println(manager.consultar(hospede3));
        // System.out.println(hospedes);
        System.out.println("--------------------------------");
        // Categoria cat = new Categoria(1, "Luxo", 550);
        // cat.cadastrar(cat);
        // cat.listar(cat);
    }
}
