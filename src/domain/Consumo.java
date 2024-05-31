package domain;

import java.util.Date;
import java.util.ArrayList;

public class Consumo {
    private Item item;
    private Reserva reserva;
    private int quantidadeSolicitada;
    private Date dataConsumo;

    public Consumo() {
        this.item = null;
        this.reserva = null;
        this.quantidadeSolicitada = 0;
        this.dataConsumo = null;
    }

    public Consumo(Item item, Reserva reserva, int quantidadeSolicitada, Date dataConsumo) {
        this.item = item;
        this.reserva = reserva;
        this.quantidadeSolicitada = quantidadeSolicitada;
        this.dataConsumo = dataConsumo;
    }
    
    public boolean cadastrar(Consumo consumo) {
        // TODO
        return true;
    }

    public boolean editar(Consumo consumo) {
        // TODO
        return true;
    }

    public Consumo consultar(Consumo consumo) {
        // TODO
        return consumo;
    }

    public ArrayList<Consumo> listar(Consumo consumo) {
        // TODO
        return new ArrayList<Consumo>();
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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

    public Date getDataConsumo() {
        return dataConsumo;
    }

    public void setDataConsumo(Date dataConsumo) {
        this.dataConsumo = dataConsumo;
    }

    
}
