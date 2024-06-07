package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import domain.Categoria;
import interfaces.*;

public class CategoriaDAO implements GenericDAOInterface<Categoria> {
  
  private static final String FILE_PATH = "src\\db\\categorias.txt";

  @Override
  public boolean cadastrar(Categoria cat) {
    if(consultar(cat) != null) {
        return false;
    }
    FileWriter fw = null;
    try {
        fw = new FileWriter(FILE_PATH, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(cat.toString());
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
  public boolean editar(Categoria cat) {
        if(consultar(cat) != null) {
            return false;
        }
        ArrayList<Categoria> categorias = listar();
        FileWriter fw = null;
        try {
            fw = new FileWriter(FILE_PATH);
            BufferedWriter bw = new BufferedWriter(fw);
            for(Categoria c: categorias) {
                if(c.getCodigo() == cat.getCodigo()) {
                    bw.write(cat.toString());
                } else {
                    bw.write(c.toString());
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
  public Categoria consultar(Categoria cat) {
      ArrayList<Categoria> categorias = listar();
      for(Categoria c: categorias) {
          if(c.getCodigo() == cat.getCodigo()) {
              return c;
          }
      }
      return null;
  } 

  @Override
  public ArrayList<Categoria> listar() {
      ArrayList<Categoria> categorias = new ArrayList<Categoria>();
      FileReader fr = null;
      try {
          fr = new FileReader(FILE_PATH); 
          BufferedReader br = new BufferedReader(fr);
          while(br.ready()) {
              String catString = br.readLine();
              String[] catInfo = catString.split(";");
              Categoria cat = new Categoria(catInfo);
              categorias.add(cat);
          }
          br.close();
          fr.close();
      } catch (IOException e) {
          System.out.println(e);
      }
      return categorias;
  }
}
