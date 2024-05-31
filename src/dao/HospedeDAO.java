package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import domain.Hospede;
import interfaces.*;

public class HospedeDAO implements HospedeDAOInterface {

    private static final String FILE_PATH = "src\\db\\hospedes.dat";

    @Override
    public boolean cadastrar(Hospede hospede) {
        /* FileWriter fw = null;
        // Método utilizando FileWriter
        try {
            fw = new FileWriter("src\\db\\hospedes.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(hospede.toString());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true; */
        ObjectOutputStream obj = null;
        ArrayList<Hospede> hospedes = listar();
        hospedes.add(hospede);
        try {
            FileOutputStream arq = new FileOutputStream(FILE_PATH);
            obj = new ObjectOutputStream(arq);
            obj.writeObject(hospedes);
            obj.flush();
            obj.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean editar(Hospede hospede) {
        
        return true;
    }

    public Hospede consultar(Hospede hospede) {
        // FileReader fr = null;
        // try {
        //     fr = new FileReader(FILE_PATH);
        //     BufferedReader br = new BufferedReader(fr);
        //     while(br.ready()) {
        //         String hospedeString = br.readLine();
        //         if(hospedeString.equalsIgnoreCase(hospede.toString())) {
        //             return hospede;
        //         }
        //     }
        // } catch (Exception e) {
        //     // TODO: handle exception
        // }
        // return null;
        ArrayList<Hospede> hospedes = listar();
        for(Hospede h: hospedes) {
            if(h.equals(hospede)) {
                return hospede;
            }
        }
        return null; 

    } 

    @Override
    @SuppressWarnings({ "unchecked" })
    public ArrayList<Hospede> listar() {
        ArrayList<Hospede> hospedes = new ArrayList<Hospede>();
        // FileReader fr = null;
        
        /* 
        // Método utilizando FileReader
        try {
            fr = new FileReader("src\\db\\hospedes.txt");
            BufferedReader br = new BufferedReader(fr);
            while(br.ready()) {
                String hospedeString = br.readLine();
                String[] hospedeInfo = hospedeString.split(";");
                hospedes.add(new Hospede(hospedeInfo[0], hospedeInfo[1], hospedeInfo[2], hospedeInfo[3]));
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            TODO: handle exception
        }
        return hospedes; */
        
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
