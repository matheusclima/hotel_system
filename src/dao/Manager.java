package dao;

import domain.*;

public class Manager {
    public GenericDAO<Hospede> hospede;
    public GenericDAO<Funcionario> funcionario;
    public GenericDAO<Servico> servico;
    public GenericDAO<Quarto> quarto;
    public GenericDAO<Categoria> categoria;

    public Manager() {
        hospede = new GenericDAO<>("src\\db\\hospedes.txt", Hospede.class);
        funcionario = new GenericDAO<>("src\\db\\funcionarios.txt", Funcionario.class);
        servico = new GenericDAO<>("src\\db\\servicos.txt", Servico.class);
        quarto = new GenericDAO<>("src\\db\\quartos.txt", Quarto.class);
        categoria = new GenericDAO<>("src\\db\\categorias.txt", Categoria.class);
    }
}
