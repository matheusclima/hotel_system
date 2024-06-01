package dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import domain.Hospede;
import interfaces.*;

public class HospedeDAOExemplo implements HospedeDAOInterfaceExemplo {

    private static final String FILE_PATH = "src\\db\\hospedes.dat";

    @Override
    public boolean salvarHospedes(ArrayList<Hospede> hospedes) {
        ObjectOutputStream obj = null;
        try {
            FileOutputStream arq = new FileOutputStream(FILE_PATH);
            obj = new ObjectOutputStream(arq);
            obj.writeObject(hospedes);
            obj.flush();
            obj.close();
        } catch (Exception e) {
            System.out.println("Erro ao salvar os hospedes: " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean cadastrar(Hospede hospede) {
        ArrayList<Hospede> hospedes = listar();
        hospedes.add(hospede);
        return salvarHospedes(hospedes);
        
    }

    @Override
    public boolean editar(Hospede hospede) {
        ArrayList<Hospede> hospedes = listar();
        boolean existe = false;
        for(int i = 0; i < hospedes.size(); i++) {
            if(hospedes.get(i).getCpf().equals(hospede.getCpf())) {
                hospedes.set(i, hospede);
                existe = true;
                break;
            }
        }
        if(existe){
            return salvarHospedes(hospedes);
        } else {
            System.out.println("Hóspede não encontrado");
            return false;
        }
    }
    
    @Override
    public Hospede consultar(Hospede hospede) {
        ArrayList<Hospede> hospedes = listar();
        for(Hospede h: hospedes) {
            if(h.getCpf().equals(hospede.getCpf())) {
                return h;
            }
        }
        return null;
    } 

    @Override
    @SuppressWarnings({ "unchecked" })
    public ArrayList<Hospede> listar() {
        ArrayList<Hospede> hospedes = new ArrayList<Hospede>();
        ObjectInputStream input = null;
        try {
            FileInputStream arquivo = new FileInputStream(FILE_PATH); 
            input = new ObjectInputStream(arquivo);
            hospedes = (ArrayList<Hospede>) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return hospedes;
    }
}
