package domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import dao.Gerenciador;
import utils.DateConversor;

public class Menu {
    private Scanner input;
    int escolhaPrincipal;

    public Menu() {
        this.input = new Scanner(System.in);
        this.escolhaPrincipal = 0;
    }
    
    public void run() {
        int escolhaMenu = 0;
        do {
            clearScreen();
            System.out.println("Selecione o Menu:");
            System.out.println("(1) Reserva");    
            System.out.println("(2) Hospede");    
            System.out.println("(3) Quarto");    
            System.out.println("(4) Servico");
            System.out.println("(5) Consumo");
            System.out.println("(6) Funcionario");
            System.out.println("(7) Categoria");
            System.out.println("(8) Item");
            System.out.println("(9) Servicos para Reserva");
            System.out.println("(10) Itens para Categoria");
            System.out.println("(11) Sair");
            escolhaMenu = Integer.valueOf(input.nextLine());
            clearScreen();
            switch (escolhaMenu) {
                case 1:
                    menuReserva();
                    break;
                case 2:
                    menuHospede();
                    break;
                case 3:
                    menuQuarto();
                    break;
                case 4:
                    menuServico();
                    break;
                case 5:
                    menuConsumo();
                    break;
                case 6:
                    menuFuncionario();
                    break;
                case 7:
                    menuCategoria();
                    break;
                case 8:
                    menuItem();
                    break;
                case 9:
                    menuReservaServico();
                    break;
                case 10:
                    menuCategoriaItem();
                    break;
                case 11:
                    System.out.println("Fechando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }    
        } while (escolhaMenu != 11);
        input.close();
    }

    private void menuReserva() {
        int opcao;
        do {
            clearScreen();
            System.out.println("===== Menu de Reserva =====");
            System.out.println("(1) Cadastrar Reserva");
            System.out.println("(2) Consultar Reserva");
            System.out.println("(3) Editar Reserva");
            System.out.println("(4) Listar Reservas");
            System.out.println("(5) Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();
            input.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.println("===== Cadastro de Reserva =====");
                    System.out.print("Digite o código da reserva: ");
                    int codigoReserva = input.nextInt();
                    input.nextLine(); 

                    System.out.print("Digite o CPF do hóspede: ");
                    String cpfHospede = input.nextLine();
                    Hospede hospede = new Hospede(); // Criando uma pessoa apenas com CPF
                    hospede.setCpf(cpfHospede);
                    hospede = Gerenciador.hospedeDAO.consultar(hospede);

                    System.out.print("Digite o código do quarto: ");
                    int codigoQuarto = input.nextInt();
                    input.nextLine(); 
                    Quarto quarto = new Quarto();
                    quarto.setCodigo(codigoQuarto);
                    quarto = Gerenciador.quartoDAO.consultar(quarto);

                    System.out.print("Digite o CPF do funcionário responsável pela reserva: ");
                    String cpfFuncionarioReserva = input.nextLine();
                    Funcionario funcionarioReserva = new Funcionario();
                    funcionarioReserva.setCpf(cpfFuncionarioReserva);
                    funcionarioReserva = Gerenciador.funcionarioDAO.consultar(funcionarioReserva);

                    System.out.print("Digite o CPF do funcionário responsável pela saida: ");
                    String cpfFuncionarioSaida = input.nextLine();
                    Funcionario funcionarioSaida = new Funcionario(); 
                    funcionarioSaida.setCpf(cpfFuncionarioSaida);
                    funcionarioSaida = Gerenciador.funcionarioDAO.consultar(funcionarioSaida);
                    
                    System.out.print("Digite a data de entrada da reserva (dd/mm/yyyy): ");
                    Date dataEntradaReserva = DateConversor.parse(input.nextLine());

                    System.out.print("Digite a data de saída da reserva (dd/mm/yyyy): ");
                    Date dataSaidaReserva = DateConversor.parse(input.nextLine());

                    System.out.print("Digite a data de checkin (dd/mm/yyyy): ");
                    Date dataCheckin = DateConversor.parse(input.nextLine());

                    System.out.print("Digite a data de checkout (dd/mm/yyyy): ");
                    Date dataCheckout = DateConversor.parse(input.nextLine());

                    System.out.print("Digite o valor da reserva (separe por virgula): ");
                    double valorReserva = input.nextDouble();
                    input.nextLine(); 

                    System.out.print("Digite o valor pago (separe por virgula): ");
                    double valorPago = input.nextDouble();
                    input.nextLine(); 

                    Reserva reserva = new Reserva(codigoReserva, hospede, quarto, funcionarioReserva, funcionarioSaida,
                            dataEntradaReserva, dataSaidaReserva, dataCheckin, dataCheckout, 
                            valorReserva, valorPago);

                    
                    boolean cadastrouReserva = Gerenciador.reservaDAO.cadastrar(reserva);

                    if (cadastrouReserva) {
                        System.out.println("Reserva cadastrada com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar reserva. Verifique os dados e tente novamente.");
                    }
                    break;

                case 2:
                    System.out.println("===== Consulta de Reserva =====");
                    System.out.print("Digite o código da reserva para consultar: ");
                    codigoReserva = input.nextInt();
                    input.nextLine(); 
                    Reserva reservaConsultada = new Reserva();
                    reservaConsultada.setCodigo(codigoReserva);
                    
                    reservaConsultada = Gerenciador.reservaDAO.consultar(reservaConsultada);

                    if (reservaConsultada != null) {
                        System.out.println("Reserva encontrada:");
                        System.out.println("Código da Reserva: " + reservaConsultada.getCodigo());
                        System.out.println("CPF do Hóspede: " + reservaConsultada.getHospede().getCpf());
                        System.out.println("Código do Quarto: " + reservaConsultada.getQuarto().getCodigo());
                        System.out.println("CPF do Funcionário (Reserva): " + reservaConsultada.getFuncionarioReserva().getCpf());
                        System.out.println("Data de Entrada: " + reservaConsultada.getDataEntradaReserva());
                        System.out.println("Data de Saída: " + reservaConsultada.getDataSaidaReserva());
                        System.out.println("Valor da Reserva: " + reservaConsultada.getValorReserva());
                    } else {
                        System.out.println("Reserva não encontrada.");
                    }
                    break;

                case 3:
                    System.out.println("===== Edição de Reserva =====");
                    System.out.print("Digite o código da reserva para editar: ");
                    codigoReserva = input.nextInt();
                    input.nextLine(); 
                    Reserva reservaEditada = new Reserva();
                    reservaEditada.setCodigo(codigoReserva);
                    
                    reservaEditada = Gerenciador.reservaDAO.consultar(reservaEditada);

                    if (reservaEditada != null) {
                        System.out.println("Reserva encontrada. Informe os novos dados:");

                        System.out.print("Digite o novo código do quarto (ou 0 para manter): ");
                        int novoCodigoQuarto = input.nextInt();
                        input.nextLine();
                        if (novoCodigoQuarto != 0) {
                            reservaEditada.getQuarto().setCodigo(novoCodigoQuarto);
                        }

                        System.out.print("Digite a nova data de entrada da reserva (ou deixe em branco para manter): ");
                        String novaDataEntradaReserva = input.nextLine();
                        if (!novaDataEntradaReserva.isEmpty()) {
                            reservaEditada.setDataEntradaReserva(DateConversor.parse(novaDataEntradaReserva));
                        }

                        System.out.print("Digite a nova data de saída da reserva (ou deixe em branco para manter): ");
                        String novaDataSaidaReserva = input.nextLine();
                        if (!novaDataSaidaReserva.isEmpty()) {
                            reservaEditada.setDataSaidaReserva(DateConversor.parse(novaDataSaidaReserva));
                        }

                        System.out.print("Digite a nova data de checkin da reserva (ou deixe em branco para manter): ");
                        String novaDataCheckin = input.nextLine();
                        if (!novaDataCheckin.isEmpty()) {
                            reservaEditada.setDataCheckin(DateConversor.parse(novaDataCheckin));
                        }

                        System.out.print("Digite a nova data de checkout da reserva (ou deixe em branco para manter): ");
                        String novaDataCheckout = input.nextLine();
                        if (!novaDataCheckout.isEmpty()) {
                            reservaEditada.setDataCheckout(DateConversor.parse(novaDataCheckout));
                        }

                        System.out.print("Digite o novo valor da reserva (ou 0 para manter) (separe por virgula): ");
                        double novoValorReserva = input.nextDouble();
                        input.nextLine();
                        if (novoValorReserva != 0) {
                            reservaEditada.setValorReserva(novoValorReserva);
                        }

                        System.out.print("Digite o novo valor pago (ou 0 para manter) (separe por virgula): ");
                        double novoValorPago = input.nextDouble();
                        input.nextLine(); 
                        if (novoValorPago != 0) {
                            reservaEditada.setValorPago(novoValorReserva);
                        }
                       
                        boolean editouReserva = Gerenciador.reservaDAO.editar(reservaEditada);

                        if (editouReserva) {
                            System.out.println("Reserva editada com sucesso!");
                        } else {
                            System.out.println("Erro ao editar reserva. Verifique os dados e tente novamente.");
                        }
                    } else {
                        System.out.println("Reserva não encontrada.");
                    }
                    break;

                case 4:
                    System.out.println("===== Listagem de Reservas =====");
                    ArrayList<Reserva> listaReservas = Gerenciador.reservaDAO.listar();

                    if (listaReservas.isEmpty()) {
                        System.out.println("Nenhuma reserva cadastrada.");
                    } else {
                        System.out.println("Lista de Reservas:");
                        for (Reserva r : listaReservas) {
                            System.out.println("Código da Reserva: " + r.getCodigo());
                            System.out.println("CPF do Hóspede: " + r.getHospede().getCpf());
                            System.out.println("Código do Quarto: " + r.getQuarto().getCodigo());
                            System.out.println("CPF do Funcionário (Reserva): " + r.getFuncionarioReserva().getCpf());
                            System.out.println("Data de Entrada: " + DateConversor.format(r.getDataEntradaReserva()));
                            System.out.println("Data de Saída: " + DateConversor.format(r.getDataSaidaReserva()));
                            System.out.println("Valor da Reserva: " + r.getValorReserva());
                            System.out.println("--------------------------------");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Voltando ao Menu Principal...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
            if(opcao != 5) esperarTecla(input);
        } while (opcao != 5);
    }

    private void menuHospede() {
        int opcao;

        do {
            clearScreen();
            System.out.println("===== Menu de Hóspede =====");
            System.out.println("1. Cadastrar Hóspede");
            System.out.println("2. Consultar Hóspede");
            System.out.println("3. Editar Hóspede");
            System.out.println("4. Listar Hóspedes");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("===== Cadastro de Hóspede =====");
                    System.out.print("Digite o CPF: ");
                    String cpf = input.nextLine();

                    System.out.print("Digite o nome: ");
                    String nome = input.nextLine();

                    System.out.print("Digite o email: ");
                    String email = input.nextLine();

                    System.out.print("Digite o endereço completo: ");
                    String enderecoCompleto = input.nextLine();

                    Hospede hospede = new Hospede(cpf, nome, email, enderecoCompleto);

                    boolean cadastrouHospede = Gerenciador.hospedeDAO.cadastrar(hospede);

                    if (cadastrouHospede) {
                        System.out.println("Hóspede cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar hóspede. Verifique os dados e tente novamente.");
                    }
                    break;

                case 2:
                    System.out.println("===== Consulta de Hóspede =====");
                    System.out.print("Digite o CPF para consultar: ");
                    cpf = input.nextLine();

                    Hospede hospedeConsultado = Gerenciador.hospedeDAO.consultar(new Hospede(cpf, "", "", ""));

                    if (hospedeConsultado != null) {
                        System.out.println("Hóspede encontrado:");
                        System.out.println("CPF: " + hospedeConsultado.getCpf());
                        System.out.println("Nome: " + hospedeConsultado.getNome());
                        System.out.println("Email: " + hospedeConsultado.getEmail());
                        System.out.println("Endereço Completo: " + hospedeConsultado.getEnderecoCompleto());
                    } else {
                        System.out.println("Hóspede não encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("===== Edição de Hóspede =====");
                    System.out.print("Digite o CPF para editar: ");
                    cpf = input.nextLine();

                    hospedeConsultado = Gerenciador.hospedeDAO.consultar(new Hospede(cpf, "", "", ""));

                    if (hospedeConsultado != null) {
                        System.out.println("Hóspede encontrado. Informe os novos dados:");

                        System.out.print("Digite o novo nome (ou deixe em branco para manter): ");
                        nome = input.nextLine();
                        if (!nome.isEmpty()) {
                            hospedeConsultado.setNome(nome);
                        }

                        System.out.print("Digite o novo email (ou deixe em branco para manter): ");
                        email = input.nextLine();
                        if (!email.isEmpty()) {
                            hospedeConsultado.setEmail(email);
                        }

                        System.out.print("Digite o novo endereço completo (ou deixe em branco para manter): ");
                        enderecoCompleto = input.nextLine();
                        if (!enderecoCompleto.isEmpty()) {
                            hospedeConsultado.setEnderecoCompleto(enderecoCompleto);
                        }

                        boolean editouHospede = Gerenciador.hospedeDAO.editar(hospedeConsultado);

                        if (editouHospede) {
                            System.out.println("Hóspede editado com sucesso!");
                        } else {
                            System.out.println("Erro ao editar hóspede. Verifique os dados e tente novamente.");
                        }
                    } else {
                        System.out.println("Hóspede não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("===== Listagem de Hóspedes =====");
                    
                    ArrayList<Hospede> listaHospedes = Gerenciador.hospedeDAO.listar();

                    if (listaHospedes.isEmpty()) {
                        System.out.println("Nenhum hóspede cadastrado.");
                    } else {
                        System.out.println("Lista de Hóspedes:");
                        for (Hospede h : listaHospedes) {
                            System.out.println("CPF: " + h.getCpf());
                            System.out.println("Nome: " + h.getNome());
                            System.out.println("Email: " + h.getEmail());
                            System.out.println("Endereço Completo: " + h.getEnderecoCompleto());
                            System.out.println("--------------------------------");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Voltando ao Menu Principal...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
            if(opcao != 5) esperarTecla(input);
        } while (opcao != 5);     
    }

    private void menuFuncionario() {
        int opcao;

        do {
            clearScreen();
            System.out.println("===== Menu de Funcionário =====");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Consultar Funcionário");
            System.out.println("3. Editar Funcionário");
            System.out.println("4. Listar Funcionários");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("===== Cadastro de Funcionário =====");
                    System.out.print("Digite o CPF: ");
                    String cpf = input.nextLine();

                    System.out.print("Digite o nome: ");
                    String nome = input.nextLine();

                    System.out.print("Digite o email: ");
                    String email = input.nextLine();

                    System.out.print("Digite o setor: ");
                    String setor = input.nextLine();

                    
                    Funcionario funcionario = new Funcionario(cpf, nome, email, setor);

                    boolean cadastrouFuncionario = Gerenciador.funcionarioDAO.cadastrar(funcionario);

                    if (cadastrouFuncionario) {
                        System.out.println("Funcionário cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar funcionário. Verifique os dados e tente novamente.");
                    }
                    break;

                case 2:
                    System.out.println("===== Consulta de Funcionário =====");
                    System.out.print("Digite o CPF para consultar: ");
                    cpf = input.nextLine();

                    Funcionario funcionarioConsultado = Gerenciador.funcionarioDAO.consultar(new Funcionario(cpf, "", "", ""));

                    if (funcionarioConsultado != null) {
                        System.out.println("Funcionário encontrado:");
                        System.out.println("CPF: " + funcionarioConsultado.getCpf());
                        System.out.println("Nome: " + funcionarioConsultado.getNome());
                        System.out.println("Email: " + funcionarioConsultado.getEmail());
                        System.out.println("Setor: " + funcionarioConsultado.getSetor());
                    } else {
                        System.out.println("Funcionário não encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("===== Edição de Funcionário =====");
                    System.out.print("Digite o CPF para editar: ");
                    cpf = input.nextLine();

                    funcionarioConsultado = Gerenciador.funcionarioDAO.consultar(new Funcionario(cpf, "", "", ""));

                    if (funcionarioConsultado != null) {
                        System.out.println("Funcionário encontrado. Informe os novos dados:");

                        System.out.print("Digite o novo nome (ou deixe em branco para manter): ");
                        nome = input.nextLine();
                        if (!nome.isEmpty()) {
                            funcionarioConsultado.setNome(nome);
                        }

                        System.out.print("Digite o novo email (ou deixe em branco para manter): ");
                        email = input.nextLine();
                        if (!email.isEmpty()) {
                            funcionarioConsultado.setEmail(email);
                        }

                        System.out.print("Digite o novo setor (ou deixe em branco para manter): ");
                        setor = input.nextLine();
                        if (!setor.isEmpty()) {
                            funcionarioConsultado.setSetor(setor);
                        }

                        boolean editouFuncionario = Gerenciador.funcionarioDAO.editar(funcionarioConsultado);

                        if (editouFuncionario) {
                            System.out.println("Funcionário editado com sucesso!");
                        } else {
                            System.out.println("Erro ao editar funcionário. Verifique os dados e tente novamente.");
                        }
                    } else {
                        System.out.println("Funcionário não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("===== Listagem de Funcionários =====");
                    
                    ArrayList<Funcionario> listaFuncionarios = Gerenciador.funcionarioDAO.listar();

                    if (listaFuncionarios.isEmpty()) {
                        System.out.println("Nenhum funcionário cadastrado.");
                    } else {
                        System.out.println("Lista de Funcionários:");
                        for (Funcionario f : listaFuncionarios) {
                            System.out.println("CPF: " + f.getCpf());
                            System.out.println("Nome: " + f.getNome());
                            System.out.println("Email: " + f.getEmail());
                            System.out.println("Setor: " + f.getSetor());
                            System.out.println("--------------------------------");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Voltando ao Menu Principal...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
            if(opcao != 5) esperarTecla(input);
        } while (opcao != 5);     
    }

    private void menuCategoria() {
        int opcao;
        do {
            System.out.println("===== Menu de Categoria =====");
            System.out.println("1. Cadastrar Categoria");
            System.out.println("2. Consultar Categoria");
            System.out.println("3. Editar Categoria");
            System.out.println("4. Listar Categorias");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();
            input.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.println("===== Cadastro de Categoria =====");
                    System.out.print("Digite o código da categoria: ");
                    int codigo = input.nextInt();
                    input.nextLine(); 

                    System.out.print("Digite a descrição: ");
                    String descricao = input.nextLine();

                    System.out.print("Digite o valor: ");
                    double valor = input.nextDouble();
                    input.nextLine(); 

                    Categoria categoria = new Categoria(codigo, descricao, valor);

                    boolean cadastrouCategoria = Gerenciador.categoriaDAO.cadastrar(categoria);

                    if (cadastrouCategoria) {
                        System.out.println("Categoria cadastrada com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar categoria. Verifique os dados e tente novamente.");
                    }
                    break;

                case 2:
                    System.out.println("===== Consulta de Categoria =====");
                    System.out.print("Digite o código da categoria para consultar: ");
                    codigo = input.nextInt();
                    input.nextLine(); 

                    Categoria categoriaConsultada = Gerenciador.categoriaDAO.consultar(new Categoria(codigo, "", 0));

                    if (categoriaConsultada != null) {
                        System.out.println("Categoria encontrada:");
                        System.out.println("Código: " + categoriaConsultada.getCodigo());
                        System.out.println("Descrição: " + categoriaConsultada.getDescricao());
                        System.out.println("Valor: " + categoriaConsultada.getValor());
                    } else {
                        System.out.println("Categoria não encontrada.");
                    }
                    break;

                case 3:
                    System.out.println("===== Edição de Categoria =====");
                    System.out.print("Digite o código da categoria para editar: ");
                    codigo = input.nextInt();
                    input.nextLine(); 

                    categoriaConsultada = Gerenciador.categoriaDAO.consultar(new Categoria(codigo, "", 0));

                    if (categoriaConsultada != null) {
                        System.out.println("Categoria encontrada. Informe os novos dados:");

                        System.out.print("Digite a nova descrição (ou deixe em branco para manter): ");
                        descricao = input.nextLine();
                        if (!descricao.isEmpty()) {
                            categoriaConsultada.setDescricao(descricao);
                        }

                        System.out.print("Digite o novo valor (ou 0 para manter): ");
                        valor = input.nextDouble();
                        input.nextLine(); 
                        if (valor != 0) {
                            categoriaConsultada.setValor(valor);
                        }

                        boolean editouCategoria = Gerenciador.categoriaDAO.editar(categoriaConsultada);

                        if (editouCategoria) {
                            System.out.println("Categoria editada com sucesso!");
                        } else {
                            System.out.println("Erro ao editar categoria. Verifique os dados e tente novamente.");
                        }
                    } else {
                        System.out.println("Categoria não encontrada.");
                    }
                    break;

                case 4:
                    System.out.println("===== Listagem de Categorias =====");
                    
                    ArrayList<Categoria> listaCategorias = Gerenciador.categoriaDAO.listar();

                    if (listaCategorias.isEmpty()) {
                        System.out.println("Nenhuma categoria cadastrada.");
                    } else {
                        System.out.println("Lista de Categorias:");
                        for (Categoria c : listaCategorias) {
                            System.out.println("Código: " + c.getCodigo());
                            System.out.println("Descrição: " + c.getDescricao());
                            System.out.println("Valor: " + c.getValor());
                            System.out.println("--------------------------------");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Voltando ao Menu Principal...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
            if(opcao != 5) esperarTecla(input);
        } while (opcao != 5);
    }

    private void menuItem() {
        int opcao;

        do {
            clearScreen();
            System.out.println("===== Menu de Item =====");
            System.out.println("1. Cadastrar Item");
            System.out.println("2. Consultar Item");
            System.out.println("3. Editar Item");
            System.out.println("4. Listar Itens");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();
            input.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.println("===== Cadastro de Item =====");
                    System.out.print("Digite o código do item: ");
                    int codigo = input.nextInt();
                    input.nextLine(); 

                    System.out.print("Digite a descrição: ");
                    String descricao = input.nextLine();

                    System.out.print("Digite o valor (separe por virgula): ");
                    double valor = input.nextDouble();
                    input.nextLine(); 

                    Item item = new Item(codigo, descricao, valor);

                    boolean cadastrouItem = Gerenciador.itemDAO.cadastrar(item);

                    if (cadastrouItem) {
                        System.out.println("Item cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar item. Verifique os dados e tente novamente.");
                    }
                    break;

                case 2:
                    System.out.println("===== Consulta de Item =====");
                    System.out.print("Digite o código do item para consultar: ");
                    codigo = input.nextInt();
                    input.nextLine(); 

                    Item itemConsultado = Gerenciador.itemDAO.consultar(new Item(codigo, "", 0));

                    if (itemConsultado != null) {
                        System.out.println("Item encontrado:");
                        System.out.println("Código: " + itemConsultado.getCodigo());
                        System.out.println("Descrição: " + itemConsultado.getDescricao());
                        System.out.println("Valor: " + itemConsultado.getValor());
                    } else {
                        System.out.println("Item não encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("===== Edição de Item =====");
                    System.out.print("Digite o código do item para editar: ");
                    codigo = input.nextInt();
                    input.nextLine(); 
            
                    itemConsultado = Gerenciador.itemDAO.consultar(new Item(codigo, "", 0));

                    if (itemConsultado != null) {
                        System.out.println("Item encontrado. Informe os novos dados:");

                        System.out.print("Digite a nova descrição (ou deixe em branco para manter): ");
                        descricao = input.nextLine();
                        if (!descricao.isEmpty()) {
                            itemConsultado.setDescricao(descricao);
                        }

                        System.out.print("Digite o novo valor (ou 0 para manter) (separe por virgula): ");
                        valor = input.nextDouble();
                        input.nextLine(); 
                        if (valor != 0) {
                            itemConsultado.setValor(valor);
                        }

                        boolean editouItem = Gerenciador.itemDAO.editar(itemConsultado);

                        if (editouItem) {
                            System.out.println("Item editado com sucesso!");
                        } else {
                            System.out.println("Erro ao editar item. Verifique os dados e tente novamente.");
                        }
                    } else {
                        System.out.println("Item não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("===== Listagem de Itens =====");
                    ArrayList<Item> listaItens = Gerenciador.itemDAO.listar();

                    if (listaItens.isEmpty()) {
                        System.out.println("Nenhum item cadastrado.");
                    } else {
                        System.out.println("Lista de Itens:");
                        for (Item i : listaItens) {
                            System.out.println("Código: " + i.getCodigo());
                            System.out.println("Descrição: " + i.getDescricao());
                            System.out.println("Valor: " + i.getValor());
                            System.out.println("--------------------------------");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Voltando ao Menu Principal...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
            if(opcao != 5) esperarTecla(input);
        } while (opcao != 5);
    }

    private void menuQuarto() {
        int opcao;

        do {
            clearScreen();
            System.out.println("===== Menu de Quarto =====");
            System.out.println("(1) Cadastrar Quarto");
            System.out.println("(2) Consultar Quarto");
            System.out.println("(3) Editar Quarto");
            System.out.println("(4) Listar Quartos");
            System.out.println("(5) Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();
            input.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.println("===== Cadastro de Quarto =====");
                    System.out.print("Digite o código do quarto: ");
                    int codigoQuarto = input.nextInt();
                    input.nextLine(); 

                    System.out.print("Digite o código da categoria: ");
                    int codigoCategoria = input.nextInt();
                    input.nextLine(); 
                    Categoria categoria = new Categoria();
                    categoria.setCodigo(codigoCategoria);
                    categoria = Gerenciador.categoriaDAO.consultar(categoria);

                    System.out.print("Digite o status do quarto: ");
                    String statusQuarto = input.nextLine();

                    Quarto quarto = new Quarto(codigoQuarto, categoria, statusQuarto);

                    boolean cadastrouQuarto = Gerenciador.quartoDAO.cadastrar(quarto);

                    if (cadastrouQuarto) {
                        System.out.println("Quarto cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar quarto. Verifique os dados e tente novamente.");
                    }
                    break;

                case 2:
                    System.out.println("===== Consulta de Quarto =====");
                    System.out.print("Digite o código do quarto para consultar: ");
                    codigoQuarto = input.nextInt();
                    input.nextLine(); 
                    Quarto quartoConsultado = new Quarto();
                    quartoConsultado.setCodigo(codigoQuarto);
                    
                    quartoConsultado = Gerenciador.quartoDAO.consultar(quartoConsultado);

                    if (quartoConsultado != null) {
                        System.out.println("Quarto encontrado:");
                        System.out.println("Código do Quarto: " + quartoConsultado.getCodigo());
                        System.out.println("Categoria do Quarto: " + quartoConsultado.getCategoria().getDescricao());
                        System.out.println("Valor da Categoria: " + quartoConsultado.getCategoria().getValor());
                        System.out.println("Status do Quarto: " + quartoConsultado.getStatus());
                    } else {
                        System.out.println("Quarto não encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("===== Edição de Quarto =====");
                    System.out.print("Digite o código do quarto para editar: ");
                    codigoQuarto = input.nextInt();
                    input.nextLine(); 
                    Quarto quartoEditado = new Quarto();
                    quartoEditado.setCodigo(codigoQuarto);
                    
                    quartoEditado = Gerenciador.quartoDAO.consultar(quartoEditado);

                    if (quartoEditado != null) {
                        System.out.println("Quarto encontrado. Informe os novos dados:");

                        System.out.print("Digite o novo código da categoria (ou 0 para manter): ");
                        int novoCodigoCategoria = input.nextInt();
                        input.nextLine(); 
                        if (novoCodigoCategoria != 0) {
                            Categoria novaCategoria = new Categoria();
                            novaCategoria.setCodigo(novoCodigoCategoria);
                            novaCategoria = Gerenciador.categoriaDAO.consultar(novaCategoria);
                            quartoEditado.setCategoria(novaCategoria);
                        }

                        System.out.print("Digite o novo status do quarto (ou deixe em branco para manter): ");
                        String novoStatusQuarto = input.nextLine();
                        if (!novoStatusQuarto.isEmpty()) {
                            quartoEditado.setStatus(novoStatusQuarto);
                        }

                        boolean editouQuarto = Gerenciador.quartoDAO.editar(quartoEditado);

                        if (editouQuarto) {
                            System.out.println("Quarto editado com sucesso!");
                        } else {
                            System.out.println("Erro ao editar quarto. Verifique os dados e tente novamente.");
                        }
                    } else {
                        System.out.println("Quarto não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("===== Listagem de Quartos =====");
                    
                    ArrayList<Quarto> listaQuartos = Gerenciador.quartoDAO.listar();

                    if (listaQuartos.isEmpty()) {
                        System.out.println("Nenhum quarto cadastrado.");
                    } else {
                        System.out.println("Lista de Quartos:");
                        for (Quarto q : listaQuartos) {
                            System.out.println("Código do Quarto: " + q.getCodigo());
                            System.out.println("Categoria do Quarto: " + q.getCategoria().getDescricao());
                            System.out.println("Valor da Categoria: " + q.getCategoria().getValor());
                            System.out.println("Status do Quarto: " + q.getStatus());
                            System.out.println("--------------------------------");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Voltando ao Menu Principal...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
            if(opcao != 5) esperarTecla(input);
        } while (opcao != 5);
    }

    private void menuServico() {
        int opcao;

        do {
            clearScreen();
            System.out.println("===== Menu de Serviço =====");
            System.out.println("1. Cadastrar Serviço");
            System.out.println("2. Consultar Serviço");
            System.out.println("3. Editar Serviço");
            System.out.println("4. Listar Serviços");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("===== Cadastro de Serviço =====");
                    System.out.print("Digite o código do serviço: ");
                    int codigoServico = input.nextInt();
                    input.nextLine();

                    System.out.print("Digite a descrição do serviço: ");
                    String descricaoServico = input.nextLine();

                    System.out.print("Digite o valor do serviço (separe por virgula): ");
                    double valorServico = input.nextDouble();
                    input.nextLine();

                    Servico servico = new Servico(codigoServico, descricaoServico, valorServico);

                    boolean cadastrouServico = Gerenciador.servicoDAO.cadastrar(servico);

                    if (cadastrouServico) {
                        System.out.println("Serviço cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar serviço. Verifique os dados e tente novamente.");
                    }
                    break;

                case 2:
                    System.out.println("===== Consulta de Serviço =====");
                    System.out.print("Digite o código do serviço para consultar: ");
                    codigoServico = input.nextInt();
                    input.nextLine();
                    Servico servicoConsultado = new Servico();
                    servicoConsultado.setCodigo(codigoServico);
                    servicoConsultado = Gerenciador.servicoDAO.consultar(servicoConsultado);

                    if (servicoConsultado != null) {
                        System.out.println("Serviço encontrado:");
                        System.out.println("Código do Serviço: " + servicoConsultado.getCodigo());
                        System.out.println("Descrição do Serviço: " + servicoConsultado.getDescricao());
                        System.out.println("Valor do Serviço: " + servicoConsultado.getValor());
                    } else {
                        System.out.println("Serviço não encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("===== Edição de Serviço =====");
                    System.out.print("Digite o código do serviço para editar: ");
                    codigoServico = input.nextInt();
                    input.nextLine();
                    Servico servicoEditado = new Servico();
                    servicoEditado.setCodigo(codigoServico);
                    
                    servicoEditado = Gerenciador.servicoDAO.consultar(servicoEditado);

                    if (servicoEditado != null) {
                        System.out.println("Serviço encontrado. Informe os novos dados:");

                        System.out.print("Digite a nova descrição do serviço (ou deixe em branco para manter): ");
                        String novaDescricaoServico = input.nextLine();
                        if (!novaDescricaoServico.isEmpty()) {
                            servicoEditado.setDescricao(novaDescricaoServico);
                        }

                        System.out.print("Digite o novo valor do serviço (ou 0 para manter) (separe por virgula): ");
                        double novoValorServico = input.nextDouble();
                        input.nextLine();
                        if (novoValorServico != 0) {
                            servicoEditado.setValor(novoValorServico);
                        }

                        boolean editouServico = Gerenciador.servicoDAO.editar(servicoEditado);

                        if (editouServico) {
                            System.out.println("Serviço editado com sucesso!");
                        } else {
                            System.out.println("Erro ao editar serviço. Verifique os dados e tente novamente.");
                        }
                    } else {
                        System.out.println("Serviço não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("===== Listagem de Serviços =====");

                    List<Servico> listaServicos = Gerenciador.servicoDAO.listar();

                    if (listaServicos.isEmpty()) {
                        System.out.println("Nenhum serviço cadastrado.");
                    } else {
                        System.out.println("Lista de Serviços:");
                        for (Servico s : listaServicos) {
                            System.out.println("Código do Serviço: " + s.getCodigo());
                            System.out.println("Descrição do Serviço: " + s.getDescricao());
                            System.out.println("Valor do Serviço: " + s.getValor());
                            System.out.println("--------------------------------");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Voltando ao Menu Principal...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
            if(opcao != 5) esperarTecla(input);
        } while (opcao != 5);
    }

    private void menuConsumo() {
        int opcao;

        do {
            clearScreen();
            System.out.println("===== Menu de Consumo =====");
            System.out.println("(1) Cadastrar Consumo");
            System.out.println("(2) Consultar Consumo");
            System.out.println("(3) Editar Consumo");
            System.out.println("(4) Listar Consumos");
            System.out.println("(5) Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();
            input.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.println("===== Cadastro de Consumo =====");
                    System.out.print("Digite o código do item: ");
                    int codigoItem = input.nextInt();
                    input.nextLine(); 

                    System.out.print("Digite o código da reserva: ");
                    int codigoReserva = input.nextInt();
                    input.nextLine(); 

                    System.out.print("Digite a quantidade solicitada: ");
                    int quantidadeSolicitada = input.nextInt();
                    input.nextLine(); 

                    System.out.print("Digite a data de consumo (dd/mm/yyyy): ");
                    Date dataConsumo = DateConversor.parse(input.nextLine());

                    Item item = new Item(codigoItem, "", 0);
                    Reserva reserva = new Reserva(codigoReserva, null, null, null, null, null, null, null, null, 0, 0);
                    
                    Consumo consumo = new Consumo(item, reserva, quantidadeSolicitada, dataConsumo);

                    boolean cadastrouConsumo = Gerenciador.consumoDAO.cadastrar(consumo);

                    if (cadastrouConsumo) {
                        System.out.println("Consumo cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar consumo. Verifique os dados e tente novamente.");
                    }
                    break;

                case 2:
                    System.out.println("===== Consulta de Consumo =====");
                    System.out.print("Digite o código do item para consultar: ");
                    codigoItem = input.nextInt();
                    input.nextLine(); 

                    System.out.print("Digite o código da reserva para consultar: ");
                    codigoReserva = input.nextInt();
                    input.nextLine(); 

                    Item itemConsumoConsulta = new Item(codigoItem, null, 0);
                    Reserva reservaConsumoConsulta = new Reserva(codigoReserva, null, null, null, null, null, null, null, null, 0, 0);
                    Consumo consumoConsultado = new Consumo(itemConsumoConsulta, reservaConsumoConsulta, 0, null);

                    consumoConsultado = Gerenciador.consumoDAO.consultar(consumoConsultado);

                    if (consumoConsultado != null) {
                        System.out.println("Consumo encontrado:");
                        System.out.println("Código do Item: " + consumoConsultado.getItem().getCodigo());
                        System.out.println("Código da Reserva: " + consumoConsultado.getReserva().getCodigo());
                        System.out.println("Quantidade Solicitada: " + consumoConsultado.getQuantidadeSolicitada());
                        System.out.println("Data de Consumo: " + DateConversor.format(consumoConsultado.getDataConsumo()));
                    } else {
                        System.out.println("Consumo não encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("===== Edição de Consumo =====");
                    System.out.print("Digite o código do item para editar: ");
                    codigoItem = input.nextInt();
                    input.nextLine(); 

                    System.out.print("Digite o código da reserva para editar: ");
                    codigoReserva = input.nextInt();
                    input.nextLine(); 

                    Item itemNovoConsumo = new Item(codigoItem, null, 0);
                    Reserva reservaNovoConsumo = new Reserva(codigoReserva, null, null, null, null, null, null, null, null, 0, 0);
                    Consumo novoConsumo = new Consumo(itemNovoConsumo, reservaNovoConsumo, 0, null);

                    novoConsumo = Gerenciador.consumoDAO.consultar(novoConsumo);

                    if (novoConsumo != null) {
                        System.out.println("Consumo encontrado. Informe os novos dados:");

                        System.out.print("Digite a nova quantidade solicitada (ou 0 para manter): ");
                        int novaQuantidadeSolicitada = input.nextInt();
                        input.nextLine(); 
                        if (novaQuantidadeSolicitada != 0) {
                            novoConsumo.setQuantidadeSolicitada(novaQuantidadeSolicitada);
                        }

                        System.out.print("Digite a nova data de consumo (ou deixe em branco para manter): ");
                        String novaDataConsumo = input.nextLine();
                        if (!novaDataConsumo.isEmpty()) {
                            novoConsumo.setDataConsumo(DateConversor.parse(novaDataConsumo));
                        }

                        // Chamada estática para editar consumo
                        boolean editouConsumo = Gerenciador.consumoDAO.editar(novoConsumo);

                        if (editouConsumo) {
                            System.out.println("Consumo editado com sucesso!");
                        } else {
                            System.out.println("Erro ao editar consumo. Verifique os dados e tente novamente.");
                        }
                    } else {
                        System.out.println("Consumo não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("===== Listagem de Consumos =====");
                    
                    ArrayList<Consumo> listaConsumos = Gerenciador.consumoDAO.listar();

                    if (listaConsumos.isEmpty()) {
                        System.out.println("Nenhum consumo cadastrado.");
                    } else {
                        System.out.println("Lista de Consumos:");
                        for (Consumo c : listaConsumos) {
                            System.out.println("Código do Item: " + c.getItem().getCodigo());
                            System.out.println("Código da Reserva: " + c.getReserva().getCodigo());
                            System.out.println("Quantidade Solicitada: " + c.getQuantidadeSolicitada());
                            System.out.println("Data de Consumo: " + DateConversor.format(c.getDataConsumo()));
                            System.out.println("--------------------------------");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Voltando ao Menu Principal...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
            if(opcao != 5) esperarTecla(input);
        } while (opcao != 5);
    }

    private void menuReservaServico() {
        int opcao;

        do {
            clearScreen();
            System.out.println("===== Menu de Serviços da Reserva =====");
            System.out.println("(1) Cadastrar Serviços da Reserva");
            System.out.println("(2) Consultar Serviços da Reserva");
            System.out.println("(3) Editar Serviços da Reserva");
            System.out.println("(4) Listar Serviços da Reserva");
            System.out.println("(5) Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("===== Cadastro de Serviço da Reserva =====");
                    System.out.print("Digite o código do serviço: ");
                    int codigoServico = input.nextInt();
                    input.nextLine();

                    System.out.print("Digite o código da reserva: ");
                    int codigoReserva = input.nextInt();
                    input.nextLine();

                    System.out.print("Digite a quantidade solicitada: ");
                    int quantidadeSolicitada = input.nextInt();
                    input.nextLine();

                    System.out.print("Digite a data do serviço (dd/mm/yyyy): ");
                    Date dataServico = DateConversor.parse(input.nextLine());

                    Servico servico = new Servico(codigoServico, "", 0);
                    Reserva reserva = new Reserva(codigoReserva, null, null, null, null, null, null, null, null, 0, 0); 
                    
                    ReservaServico reservaServico = new ReservaServico(servico, reserva, quantidadeSolicitada, dataServico);

                    boolean cadastrouReservaServico = Gerenciador.reservaServicoDAO.cadastrar(reservaServico);

                    if (cadastrouReservaServico) {
                        System.out.println("Reserva de serviço cadastrada com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar reserva de serviço. Verifique os dados e tente novamente.");
                    }
                    break;

                case 2:
                    System.out.println("===== Consulta de Serviço da Reserva =====");
                    System.out.print("Digite o código do serviço para consultar: ");
                    codigoServico = input.nextInt();
                    input.nextLine();

                    System.out.print("Digite o código da reserva para consultar: ");
                    codigoReserva = input.nextInt();
                    input.nextLine();

                    Servico servicoParaConsulta = new Servico(codigoServico, null, 0);
                    Reserva reservaParaConsulta = new Reserva(codigoReserva, null, null, null, null, null, null, null, null, 0, 0);
                    ReservaServico reservaServicoConsultada = new ReservaServico(servicoParaConsulta, reservaParaConsulta, 0, null);
                    reservaServicoConsultada = Gerenciador.reservaServicoDAO.consultar(reservaServicoConsultada);

                    if (reservaServicoConsultada != null) {
                        System.out.println("Reserva de Serviço encontrada:");
                        System.out.println("Código do Serviço: " + reservaServicoConsultada.getServico().getCodigo());
                        System.out.println("Código da Reserva: " + reservaServicoConsultada.getReserva().getCodigo());
                        System.out.println("Quantidade Solicitada: " + reservaServicoConsultada.getQuantidadeSolicitada());
                        System.out.println("Data do Serviço: " + DateConversor.format(reservaServicoConsultada.getDataServico()));
                    } else {
                        System.out.println("Reserva de Serviço não encontrada.");
                    }
                    break;

                case 3:
                    System.out.println("===== Edição de Reserva de Serviço =====");
                    System.out.print("Digite o código do serviço para editar: ");
                    codigoServico = input.nextInt();
                    input.nextLine();

                    System.out.print("Digite o código da reserva para editar: ");
                    codigoReserva = input.nextInt();
                    input.nextLine();

                    Servico servicoParaEditar = new Servico(codigoServico, null, 0);
                    Reserva reservaParaEditar = new Reserva(codigoReserva, null, null, null, null, null, null, null, null, 0, 0);
                    
                    ReservaServico novoServicoReserva = Gerenciador.reservaServicoDAO.consultar(new ReservaServico(servicoParaEditar, reservaParaEditar, 0, null));

                    if (novoServicoReserva != null) {
                        System.out.println("Reserva de Serviço encontrada. Informe os novos dados:");

                        System.out.print("Digite a nova quantidade solicitada (ou 0 para manter): ");
                        int novaQuantidadeSolicitada = input.nextInt();
                        input.nextLine();
                        if (novaQuantidadeSolicitada != 0) {
                            novoServicoReserva.setQuantidadeSolicitada(novaQuantidadeSolicitada);
                        }

                        System.out.print("Digite a nova data do serviço (ou deixe em branco para manter): ");
                        String novaDataServico = input.nextLine();
                        if (!novaDataServico.isEmpty()) {
                            novoServicoReserva.setDataServico(DateConversor.parse(novaDataServico));
                        }

                       boolean editouReservaServico = Gerenciador.reservaServicoDAO.editar(novoServicoReserva);

                        if (editouReservaServico) {
                            System.out.println("Reserva de Serviço editada com sucesso!");
                        } else {
                            System.out.println("Erro ao editar reserva de serviço. Verifique os dados e tente novamente.");
                        }
                    } else {
                        System.out.println("Reserva de Serviço não encontrada.");
                    }
                    break;

                case 4:
                    System.out.println("===== Listagem de Serviços da Reserva =====");
                    ArrayList<ReservaServico> listaReservaServicos = Gerenciador.reservaServicoDAO.listar();

                    if (listaReservaServicos.isEmpty()) {
                        System.out.println("Nenhuma reserva de serviço cadastrada.");
                    } else {
                        System.out.println("Lista de Reservas de Serviços:");
                        for (ReservaServico rs : listaReservaServicos) {
                            System.out.println("Código do Serviço: " + rs.getServico().getCodigo());
                            System.out.println("Código da Reserva: " + rs.getReserva().getCodigo());
                            System.out.println("Quantidade Solicitada: " + rs.getQuantidadeSolicitada());
                            System.out.println("Data do Serviço: " + DateConversor.format(rs.getDataServico()));
                            System.out.println("--------------------------------");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Voltando ao Menu Principal...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
            if(opcao != 5) esperarTecla(input);
        } while (opcao != 5);
    }

    private void menuCategoriaItem() {
        int opcao;

        do {
            System.out.println("===== Menu de Categoria Item =====");
            System.out.println("(1) Cadastrar Categoria Item");
            System.out.println("(2) Consultar Categoria Item");
            System.out.println("(3) Editar Categoria Item");
            System.out.println("(4) Listar Categoria Items");
            System.out.println("(5) Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("===== Cadastro de Categoria Item =====");
                    System.out.print("Digite o código do item: ");
                    int codigoItem = input.nextInt();
                    input.nextLine();

                    System.out.print("Digite o código da categoria: ");
                    int codigoCategoria = input.nextInt();
                    input.nextLine();

                    System.out.print("Digite a quantidade: ");
                    int quantidade = input.nextInt();
                    input.nextLine();

                    Item item = new Item(codigoItem, "", 0);
                    Categoria categoria = new Categoria(codigoCategoria, "", 0); 

                    CategoriaItem categoriaItem = new CategoriaItem(item, categoria, quantidade);

                    // Chamada estática para cadastrar categoria item
                    boolean cadastrouCategoriaItem = Gerenciador.categoriaItemDAO.cadastrar(categoriaItem);

                    if (cadastrouCategoriaItem) {
                        System.out.println("Categoria Item cadastrada com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar categoria item. Verifique os dados e tente novamente.");
                    }
                    break;

                case 2:
                    System.out.println("===== Consulta de Categoria Item =====");
                    System.out.print("Digite o código do item para consultar: ");
                    codigoItem = input.nextInt();
                    input.nextLine();

                    System.out.print("Digite o código da categoria para consultar: ");
                    codigoCategoria = input.nextInt();
                    input.nextLine();

                    CategoriaItem categoriaItemConsultada = Gerenciador.categoriaItemDAO.consultar(new CategoriaItem(new Item(codigoItem,"",0), new Categoria(codigoCategoria, null, 0), 0));

                    if (categoriaItemConsultada != null) {
                        System.out.println("Categoria Item encontrada:");
                        System.out.println("Código do Item: " + categoriaItemConsultada.getItem().getCodigo());
                        System.out.println("Código da Categoria: " + categoriaItemConsultada.getCategoria().getCodigo());
                        System.out.println("Quantidade: " + categoriaItemConsultada.getQuantidade());
                    } else {
                        System.out.println("Categoria Item não encontrada.");
                    }
                    break;

                case 3:
                    System.out.println("===== Edição de Categoria Item =====");
                    System.out.print("Digite o código do item para editar: ");
                    codigoItem = input.nextInt();
                    input.nextLine();

                    System.out.print("Digite o código da categoria para editar: ");
                    codigoCategoria = input.nextInt();
                    input.nextLine();

                    Item itemParaEditar = new Item(codigoItem, null, 0);
                    Categoria categoriaParaEditar = new Categoria(codigoCategoria, null, 0);
                    CategoriaItem novaCategoriaItem = Gerenciador.categoriaItemDAO.consultar(new CategoriaItem(itemParaEditar, categoriaParaEditar, 0));

                    if (novaCategoriaItem != null) {
                        System.out.println("Categoria Item encontrada. Informe os novos dados:");

                        System.out.print("Digite a nova quantidade (ou 0 para manter): ");
                        int novaQuantidade = input.nextInt();
                        input.nextLine();
                        if (novaQuantidade != 0) {
                            novaCategoriaItem.setQuantidade(novaQuantidade);
                        }

                        boolean editouCategoriaItem = Gerenciador.categoriaItemDAO.editar(novaCategoriaItem);

                        if (editouCategoriaItem) {
                            System.out.println("Categoria Item editada com sucesso!");
                        } else {
                            System.out.println("Erro ao editar categoria item. Verifique os dados e tente novamente.");
                        }
                    } else {
                        System.out.println("Categoria Item não encontrada.");
                    }
                    break;

                case 4:
                    System.out.println("===== Listagem de Categoria Items =====");
                    
                    ArrayList<CategoriaItem> listaCategoriaItems = Gerenciador.categoriaItemDAO.listar();

                    if (listaCategoriaItems.isEmpty()) {
                        System.out.println("Nenhuma categoria item cadastrada.");
                    } else {
                        System.out.println("Lista de Categoria Items:");
                        for (CategoriaItem ci : listaCategoriaItems) {
                            System.out.println("Código do Item: " + ci.getItem().getCodigo());
                            System.out.println("Código da Categoria: " + ci.getCategoria().getCodigo());
                            System.out.println("Quantidade: " + ci.getQuantidade());
                            System.out.println("--------------------------------");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Voltando ao Menu Principal...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);
    }

    private static void clearScreen() {  
        // System.out.print("\033[H\033[2J");  
        // System.out.flush();
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");  
        } catch (IOException e) {
            System.out.println("Erro ao limpar tela: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Erro ao limpar tela: " + e.getMessage());
        }
    }  

    public static void esperarTecla(Scanner scanner) {
        System.out.println("Pressione qualquer tecla para continuar...");
        try {
            System.in.read();
            scanner.nextLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
