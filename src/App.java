
import java.util.Date;

import dao.Manager;
import domain.*;

public class App {
    public static void main(String[] args) throws Exception {
        Manager manager = new Manager();
        
        Quarto quarto = new Quarto(1, null, null);
        quarto = manager.quarto.consultar(quarto);

        Hospede hospede = new Hospede("058888923-78", null, null, null);
        hospede = manager.hospede.consultar(hospede);
        // System.out.println(manager.hospede.editar(hospede));
        
        Funcionario funcionarioSaida = new Funcionario("32165478-99", "Jose", null, "A");
        // // manager.funcionario.cadastrar(funcionarioSaida);
        Funcionario funcionarioReserva = new Funcionario("1234567-85", "Jose", null, "A");
        // // manager.funcionario.cadastrar(funcionarioReserva);
        Reserva reserva = new Reserva(1257, hospede, quarto, funcionarioReserva, funcionarioSaida, new Date(), new Date(), new Date(), new Date(), 150, 80);
        
        manager.reserva.editar(reserva);
        Reserva teste = manager.reserva.consultar(reserva);
        System.out.println(teste.getDataEntradaReserva());
        // Menu menu = new Menu();
        // Menu.clearScreen();
        // menu.run();
    }
}
