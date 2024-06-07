package domain;

import java.util.Scanner;

import dao.Manager;

public class Menu {
    private Scanner input;
    private Manager manager;

    public Menu() {
        this.input = new Scanner(System.in);
        this.manager = new Manager();
    }
    
    public void run() {
        int escolha = 0;
        System.out.println("Escolha uma ação:");
        System.out.println("(1) Cadastrar");    
        System.out.println("(2) Editar");    
        System.out.println("(3) Consultar");    
        System.out.println("(4) Listar");
        escolha = Integer.parseInt(input.nextLine());
        clearScreen();
        switch (escolha) {
            case 1:
                cadastrar();
                break;
            
            case 4:
                listar();
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }    
    }

    public void cadastrar() {
        int escolha = 0;
        String cpf, nome, email, enderecoCompleto, desc, setor;
        int codigo;
        double valor;
        System.out.println("O que deseja cadastrar?");
        System.out.println("(1) Hospede");
        System.out.println("(2) Funcionario");
        System.out.println("(3) Servico");
        System.out.println("(4) Voltar");
        System.out.println("(5) Fechar");
        escolha = Integer.parseInt(input.nextLine());
        clearScreen();
        switch (escolha) {
            case 1:
                // System.out.println("Preencha as informaçoes sobre o hóspede.");
                // System.out.println("Digite o cpf:");
                // cpf = input.nextLine();
                // System.out.println("Digite o nome:");
                // nome = input.nextLine();
                // System.out.println("Digite o email:");
                // email = input.nextLine();
                // System.out.println("Digite o endereço completo:");
                // enderecoCompleto = input.nextLine();
                // Hospede hospede = new Hospede(cpf, nome, email, enderecoCompleto);
                Hospede hospede = Hospede.menuCadastroFuncionario();
                manager.hospede.cadastrar(hospede);            
                break;
            
            case 2:
                System.out.println("Preencha as informaçoes sobre o funcionario.");
                System.out.println("Digite o cpf:");
                cpf = input.nextLine();
                System.out.println("Digite o nome:");
                nome = input.nextLine();
                System.out.println("Digite o email:");
                email = input.nextLine();
                System.out.println("Digite o setor:");
                enderecoCompleto = input.nextLine();
                Funcionario func = new Funcionario(cpf, nome, email, enderecoCompleto);
                manager.funcionario.cadastrar(func);              
                clearScreen();
                break;

            case 3:
                System.out.println("Preencha as informaçoes sobre o servico.");
                System.out.println("Digite o codigo do serviço:");
                codigo = Integer.parseInt(input.nextLine());
                System.out.println("Digite a descrição do serviço:");
                desc = input.nextLine();
                System.out.println("Digite o valor do serviço:");
                valor = Double.parseDouble(input.nextLine());
                Servico serv = new Servico(codigo, desc, valor);
                manager.servico.cadastrar(serv);    
                clearScreen();
                break;
            case 4:
                clearScreen();
            case 5:
                clearScreen();
                break;

            default:
                System.out.println("Opção invalida!");
                break;
        }
    }

    public void listar() {

    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
}
