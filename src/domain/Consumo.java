package domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.Manager;

public class Consumo extends Generic {
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
        Manager manager = new Manager();
        this.item.setCodigo(Integer.parseInt(attr[0]));
        this.item = manager.item.consultar(this.item);
        this.reserva.setCodigo(Integer.parseInt(attr[1]));
        this.reserva = manager.reserva.consultar(this.reserva);
        this.quantidadeSolicitada = Integer.parseInt(attr[2]);
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            this.dataConsumo = df.parse(attr[3]);
        } catch (ParseException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return String.format("%d;%d;%d;%s", item.getCodigo(), 
                        reserva.getCodigo(), quantidadeSolicitada, df.format(dataConsumo));
    }

    @Override
    public String getId() {
        return String.valueOf(this.reserva.getCodigo());
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
