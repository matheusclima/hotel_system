package dao;

import domain.Reserva;
import utils.*;
public class ReservaDAO extends GenericDAO<Reserva> {
    
    public ReservaDAO() {
        super("src\\db\\reservas.txt", Reserva.class);
    }
    
    @Override
    protected String getId(Reserva reserva) {
        return String.valueOf(reserva.getCodigo());
    }

    @Override
    protected String toString(Reserva reserva) {
        return String.format("%d;%s;%d;%s;%s;%s;%s;%s;%s;%.2f;%.2f", reserva.getCodigo(), reserva.getHospede().getCpf(), reserva.getQuarto().getCodigo(), 
                                                reserva.getFuncionarioReserva().getCpf(), reserva.getFuncionarioSaida().getCpf(),
                                                DateConversor.format(reserva.getDataEntradaReserva()), DateConversor.format(reserva.getDataSaidaReserva()),
                                                DateConversor.format(reserva.getDataCheckin()), DateConversor.format(reserva.getDataCheckout()), reserva.getValorReserva(), reserva.getValorPago());
    }
}
