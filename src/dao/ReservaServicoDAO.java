package dao;

import domain.ReservaServico;
import utils.*;

public class ReservaServicoDAO extends GenericDAO<ReservaServico> {
    
    public ReservaServicoDAO() {
        super("src\\db\\reserva_servico.txt", ReservaServico.class);
    }

    @Override
    protected String getId(ReservaServico reservaServico) {
        return String.format("%d@%d", reservaServico.getServico().getCodigo(), reservaServico.getReserva().getCodigo());
    }

    @Override
    protected String toString(ReservaServico reservaServico) {
        return String.format("%d;%d;%d;%s", reservaServico.getServico().getCodigo(), reservaServico.getReserva().getCodigo(),
                                        reservaServico.getQuantidadeSolicitada(), DateConversor.format(reservaServico.getDataServico()));
    }
}
