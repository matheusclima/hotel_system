package domain;

import java.util.Date;

import dao.Gerenciador;
import utils.DateConversor;

public class Consumo {
    private Item item;
    private Reserva reserva;
    private int quantidadeSolicitada;
    private Date dataConsumo;

    public Consumo() {
        this.item = new Item();
        this.reserva = new Reserva();
        this.quantidadeSolicitada = 0;
        this.dataConsumo = new Date();
    }

    public Consumo(Item item, Reserva reserva, int quantidadeSolicitada, Date dataConsumo) {
        this.item = item;
        this.reserva = reserva;
        this.quantidadeSolicitada = quantidadeSolicitada;
        this.dataConsumo = dataConsumo;
    }

    public Consumo(String[] attr) {
        this.item = new Item();
        this.item.setCodigo(Integer.parseInt(attr[0]));
        this.item = Gerenciador.itemDAO.consultar(this.item);
        this.reserva = new Reserva();
        this.reserva.setCodigo(Integer.parseInt(attr[1]));
        this.reserva = Gerenciador.reservaDAO.consultar(this.reserva);
        this.quantidadeSolicitada = Integer.parseInt(attr[2]);
        this.dataConsumo = DateConversor.parse(attr[3]);
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
