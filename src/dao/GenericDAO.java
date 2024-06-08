package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import domain.Generic;
import interfaces.GenericDAOInterface;

public class GenericDAO<T extends Generic> implements GenericDAOInterface<T> {
    private final String FILE_PATH;
    private final Class<T> type;

    public GenericDAO(String FILE_PATH, Class<T> type) {
        this.FILE_PATH = FILE_PATH;
        this.type = type;
    }

    @Override
    public boolean cadastrar(T objecT) {
        if(consultar(objecT) != null) return false;

        FileWriter fw = null;
        try {
            fw = new FileWriter(FILE_PATH, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(objecT.toString());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
            return false;
        }
        return true;
        
    }

    @Override
    public boolean editar(T objecT) {
        if(consultar(objecT) == null) return false;
        
        ArrayList<T> objecTs = listar();
        FileWriter fw = null;
        try {
            fw = new FileWriter(FILE_PATH);
            BufferedWriter bw = new BufferedWriter(fw);
            for(T objT: objecTs) {
                if(objT.getId().equals(objecT.getId())) {
                    bw.write(objecT.toString());
                } else {
                    bw.write(objT.toString());
                }
                bw.newLine();
            }
            bw.close();
            fw.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    @Override
    public T consultar(T objecT)  {
        ArrayList<T> objecTs = listar();
        for(T objT: objecTs) {
            if(objT.getId().equals(objecT.getId())) {
                return objT;
            }
        }
        return null;
    } 

    @Override
    public ArrayList<T> listar() {
        ArrayList<T> objecTs = new ArrayList<T>();
        FileReader fr = null;
        try {
            fr = new FileReader(FILE_PATH); 
            BufferedReader br = new BufferedReader(fr);
            while(br.ready()) {
                String line = br.readLine();
                String[] attr = line.split(";");
                try {
                    T objecT = type.getConstructor(String[].class).newInstance(new Object[] {attr});    
                    objecTs.add(objecT);
                } catch (ReflectiveOperationException e) {
                    System.out.println(e.getMessage());
                }
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return objecTs;
    }
}
