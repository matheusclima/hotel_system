package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import domain.Hospede;
import interfaces.*;

public class HospedeDAO implements GenericDAOInterface<Hospede> {

    private static final String FILE_PATH = "src\\db\\hospedes.txt";

    @Override
    public boolean cadastrar(Hospede hospede) {
        if(consultar(hospede) != null) {
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
        if(consultar(hospede) != null) {
            return false;
        }
        ArrayList<Hospede> hospedes = listar();
        FileWriter fw = null;
        try {
            fw = new FileWriter(FILE_PATH);
            BufferedWriter bw = new BufferedWriter(fw);
            for(Hospede h: hospedes) {
                if(h.getCpf() == hospede.getCpf()) {
                    bw.write(hospede.toString());
                } else {
                    bw.write(h.toString());
                }
                bw.newLine();
            }
            bw.close();
            fw.close();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    @Override
    public Hospede consultar(Hospede hospede) {
        ArrayList<Hospede> hospedes = listar();
        for(Hospede h: hospedes) {
            if(h.getCpf() == hospede.getCpf()) {
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
                Hospede hospede = new Hospede();
                hospedes.add(hospede);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return hospedes;
    }
}
