package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import domain.Hospede;
import interfaces.*;

public class HospedeDAO implements DAOInterface<Hospede> {

    private static final String FILE_PATH = "src\\db\\hospedes.txt";

    @Override
    public boolean cadastrar(Hospede hospede) {
        if(consultar(hospede).equals(null)) {
            return false;
        }
        FileWriter fw = null;
        try {
            fw = new FileWriter(FILE_PATH, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(hospede.toString());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Erro ao salvar os hospedes: " + e.getMessage());
            return false;
        }
        return true;
        
    }

    @Override
    public boolean editar(Hospede hospede) {
        return false;
        // ArrayList<Hospede> hospedes = listar();
        // boolean encontrado = false;
        // for(int i = 0; i < hospedes.size(); i++) {
        //     if(hospedes.get(i).getCpf().equals(hospede.getCpf())) {
        //         hospedes.set(i, hospede);
        //         encontrado = true;
        //         break;
        //     }
        // }
        // if(encontrado){
        //     return (hospedes);
        // } else {
        //     System.out.println("Hóspede não encontrado");
        //     return false;
        // }
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
    public ArrayList<Hospede> listar() {
        ArrayList<Hospede> hospedes = new ArrayList<Hospede>();
        FileReader fr = null;
        try {
            fr = new FileReader(FILE_PATH); 
            BufferedReader br = new BufferedReader(fr);
            while(br.ready()) {
                String hospedeString = br.readLine();
                String[] hospInfo = hospedeString.split(";");
                Hospede hospede = new Hospede(hospInfo[0], hospInfo[1], hospInfo[2], hospInfo[3]);
                hospedes.add(hospede);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return hospedes;
    }
}
