package domain;

import java.util.Scanner;

public class Hospede extends Pessoa {
    private String enderecoCompleto;
    
    public Hospede() {
        super();
        this.enderecoCompleto = "";
    }

    public Hospede(String cpf, String nome, String email, String enderecoCompleto) {
        super(cpf, nome, email);
        this.enderecoCompleto = enderecoCompleto;
    }

    public Hospede(String[] attr) {
        super(attr);
        this.enderecoCompleto = attr[attr.length-1];
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s", this.getCpf(), this.getNome(), this.getEmail(), this.enderecoCompleto);
    }

    public String getEnderecoCompleto() {
        return enderecoCompleto;
    }

    public void setEnderecoCompleto(String enderecoCompleto) {
        this.enderecoCompleto = enderecoCompleto;
    }

    public static Hospede menuCadastroFuncionario() {
        Scanner input = new Scanner(System.in);
        System.out.println("Preencha as informaçoes sobre o hóspede.");
        System.out.println("Digite o cpf:");
        String cpf = input.nextLine();
        System.out.println("Digite o nome:");
        String nome = input.nextLine();
        System.out.println("Digite o email:");
        String email = input.nextLine();
        System.out.println("Digite o endereço completo:");
        String enderecoCompleto = input.nextLine();
        Hospede hospede = new Hospede(cpf, nome, email, enderecoCompleto);
        input.close();
        return hospede;
    }

}
