package dao;

import domain.Consumo;
import utils.*;

public class ConsumoDAO extends GenericDAO<Consumo> {
    
    public ConsumoDAO() {
        super("src\\db\\consumos.txt", Consumo.class);
    }

    @Override
    protected String getId(Consumo consumo) {
        return String.valueOf(consumo.getReserva().getCodigo());
    }

    @Override
    protected String toString(Consumo consumo) {
        return String.format("%d;%d;%d;%s", consumo.getItem().getCodigo(), consumo.getReserva().getCodigo(),
                                            consumo.getQuantidadeSolicitada(), DateConversor.format(consumo.getDataConsumo()));
    }
}
