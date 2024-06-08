package domain;

import java.util.Date;

public class ConsumoServico extends Generic {
    private Servico servico;
    private Consumo consumo;
    private Reserva reserva;
    private int quantidadeSolicitada;
    private Date dataServico;

    public ConsumoServico() {
        this.servico = new Servico();
        this.consumo = new Consumo();
        this.reserva = new Reserva();
        this.quantidadeSolicitada = 0;
        this.dataServico = new Date();
    }

    public ConsumoServico(Servico servico, Consumo consumo, Reserva reserva, int quantidadeSolicitada,
            Date dataServico) {
        this.servico = servico;
        this.consumo = consumo;
        this.reserva = reserva;
        this.quantidadeSolicitada = quantidadeSolicitada;
        this.dataServico = dataServico;
    }

    public ConsumoServico(String[] attr) {
        this.servico.setCodigo(Integer.parseInt(attr[0]));
        this.reserva.setCodigo(Integer.parseInt(attr[1]));
    }

    @Override
    public String getId() {
        return String.valueOf(this.reserva.getCodigo());
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
