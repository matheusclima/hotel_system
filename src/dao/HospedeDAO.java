package dao;

import domain.Hospede;

public class HospedeDAO extends GenericDAO<Hospede> {
    
    public HospedeDAO() {
        super("src\\db\\hospedes.txt", Hospede.class);
    }

    @Override
    protected String getId(Hospede hospede) {
        return hospede.getCpf();
    }

    @Override
    protected String toString(Hospede hosp) {
        return String.format("%s;%s;%s;%s", hosp.getCpf(), hosp.getNome(), hosp.getEmail(), hosp.getEnderecoCompleto());
    }


}
