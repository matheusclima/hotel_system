package domain;

import java.util.Date;

import dao.Gerenciador;
import utils.DateConversor;

public class ReservaServico {
    private Servico servico;
    private Reserva reserva;
    private int quantidadeSolicitada;
    private Date dataServico;

    public ReservaServico() {
        this.servico = new Servico();
        this.reserva = new Reserva();
        this.quantidadeSolicitada = 0;
        this.dataServico = new Date();
    }

    public ReservaServico(Servico servico, Reserva reserva, int quantidadeSolicitada,
            Date dataServico) {
        this.servico = servico;
        this.reserva = reserva;
        this.quantidadeSolicitada = quantidadeSolicitada;
        this.dataServico = dataServico;
    }

    public ReservaServico(String[] attr) {
        this.servico = new Servico();
        this.servico.setCodigo(Integer.parseInt(attr[0]));
        this.servico = Gerenciador.servicoDAO.consultar(this.servico);

        this.reserva = new Reserva();
        this.reserva.setCodigo(Integer.parseInt(attr[1]));
        this.reserva = Gerenciador.reservaDAO.consultar(this.reserva);

        this.quantidadeSolicitada = Integer.parseInt(attr[2]);
        this.dataServico = DateConversor.parse(attr[3]);
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public int getQuantidadeSolicitada() {
        return quantidadeSolicitada;
    }

    public void setQuantidadeSolicitada(int quantidadeSolicitada) {
        this.quantidadeSolicitada = quantidadeSolicitada;
    }

    public Date getDataServico() {
        return dataServico;
    }

    public void setDataServico(Date dataServico) {
        this.dataServico = dataServico;
    }
    
}
