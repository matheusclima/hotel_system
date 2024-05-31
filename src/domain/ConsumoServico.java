package domain;

import java.util.Date;
import java.util.ArrayList;

public class ConsumoServico {
    private Servico servico;
    private Consumo consumo;
    private Reserva reserva;
    private int quantidadeSolicitada;
    private Date dataServico;

    public ConsumoServico() {
        this.servico = null;
        this.consumo = null;
        this.reserva = null;
        this.quantidadeSolicitada = 0;
        this.dataServico = null;
    }

    public ConsumoServico(Servico servico, Consumo consumo, Reserva reserva, int quantidadeSolicitada,
            Date dataServico) {
        this.servico = servico;
        this.consumo = consumo;
        this.reserva = reserva;
        this.quantidadeSolicitada = quantidadeSolicitada;
        this.dataServico = dataServico;
    }

    public boolean cadastrar(ConsumoServico consumoServico) {
        // TODO
        return true;
    }

    public boolean editar(ConsumoServico consumoServico) {
        // TODO
        return true;
    }

    public ConsumoServico consultar(ConsumoServico consumoServico) {
        // TODO
        return consumoServico;
    }

    public ArrayList<ConsumoServico> listar(ConsumoServico consumoServico) {
        // TODO
        return new ArrayList<ConsumoServico>();
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Consumo getConsumo() {
        return consumo;
    }

    public void setConsumo(Consumo consumo) {
        this.consumo = consumo;
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
