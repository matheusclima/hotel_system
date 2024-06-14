package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import interfaces.GenericDAOInterface;

public abstract class GenericDAO<T> implements GenericDAOInterface<T> {
    private final String FILE_PATH;
    private final Class<T> type;

    protected abstract String getId(T t);
    protected abstract String toString(T t);

    public GenericDAO(String FILE_PATH, Class<T> type) {
        this.FILE_PATH = FILE_PATH;
        this.type = type;
        createFile();
    }

    @Override
    public boolean cadastrar(T objecT) {
        if(consultar(objecT) != null) {
            return false;
        }        
        
        FileWriter fw = null;
        try {
            fw = new FileWriter(FILE_PATH, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(toString(objecT));
            bw.newLine();
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
            return false;
        } catch(NullPointerException e) {
            System.out.println("Erro ao salvar: Nao foi possivel acessar campo de null");
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
                if(getId(objT).equals(getId(objecT))) {
                    bw.write(toString(objecT));
                } else {
                    bw.write(toString(objT));
                }
                bw.newLine();
            }
            bw.close();
            fw.close();
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    @Override
    public T consultar(T objecT)  {
        ArrayList<T> objecTs = listar();
        for(T objT: objecTs) {
            if(getId(objT).equals(getId(objecT))) {
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

    private void createFile() {
        File file = new File(FILE_PATH);
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Erro ao criar arquivo");
                e.printStackTrace();
            }
        }
    }
}
