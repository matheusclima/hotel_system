package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import domain.Categoria;
import interfaces.*;

public class CategoriaDAO implements DAOInterface<Categoria> {
  
  private static final String FILE_PATH = "src\\db\\categorias.txt";

  @Override
  public boolean cadastrar(Categoria cat) {
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
              Categoria cat = new Categoria(Integer.parseInt(catInfo[0]), catInfo[1], Double.parseDouble(catInfo[2]));
              categorias.add(cat);
          }
      } catch (IOException e) {
          System.out.println(e);
      }
      return categorias;
  }
}
