package domain;

import java.util.Date;

import dao.Gerenciador;
import utils.DateConversor;

public class Reserva {
    private int codigo;
    private Hospede hospede;
    private Quarto quarto;
    private Funcionario funcionarioReserva;
    private Funcionario funcionarioSaida;
    private Date dataEntradaReserva;
    private Date dataSaidaReserva;
    private Date dataCheckin;
    private Date dataCheckout;
    private double valorReserva;
    private double valorPago;

    public Reserva() {
        this.codigo = 0;
        this.hospede = new Hospede();
        this.quarto = new Quarto();
        this.funcionarioReserva = new Funcionario();
        this.funcionarioSaida = new Funcionario();
        this.dataEntradaReserva = new Date();
        this.dataSaidaReserva = new Date();
        this.dataCheckin = new Date();
        this.dataCheckout = new Date();
        this.valorReserva = 0.0;
        this.valorPago = 0.0;
    }

    public Reserva(int codigo, Hospede hospede, Quarto quarto, Funcionario funcionarioReserva,
        Funcionario funcionarioSaida, Date dataEntradaReserva, Date dataSaidaReserva, Date dataCheckin,
        Date dataCheckout, double valorReserva, double valorPago) {
        this.codigo = codigo;
        this.hospede = hospede;
        this.quarto = quarto;
        this.funcionarioReserva = funcionarioReserva;
        this.funcionarioSaida = funcionarioSaida;
        this.dataEntradaReserva = dataEntradaReserva;
        this.dataSaidaReserva = dataSaidaReserva;
        this.dataCheckin = dataCheckin;
        this.dataCheckout = dataCheckout;
        this.valorReserva = valorReserva;
        this.valorPago = valorPago;
    }

    public Reserva(String[] attr) {
        
        this.codigo = Integer.parseInt(attr[0]);
        this.hospede = new Hospede();
        this.hospede.setCpf(attr[1]);
        this.hospede = Gerenciador.hospedeDAO.consultar(this.hospede);

        this.quarto = new Quarto();
        this.quarto.setCodigo(Integer.parseInt(attr[2]));
        this.quarto = Gerenciador.quartoDAO.consultar(this.quarto);

        this.funcionarioReserva = new Funcionario();
        this.funcionarioReserva.setCpf(attr[3]);
        this.funcionarioReserva = Gerenciador.funcionarioDAO.consultar(this.funcionarioReserva);

        this.funcionarioSaida = new Funcionario();
        this.funcionarioSaida.setCpf(attr[4]);
        this.funcionarioSaida = Gerenciador.funcionarioDAO.consultar(this.funcionarioSaida);
        
        this.dataEntradaReserva = DateConversor.parse(attr[5]);
        this.dataEntradaReserva = DateConversor.parse(attr[6]);
        this.dataCheckin = DateConversor.parse(attr[7]);
        this.dataCheckout = DateConversor.parse(attr[8]);
        
        this.valorPago = Double.parseDouble(attr[9].replace(",", "."));
        this.valorReserva = Double.parseDouble(attr[10].replace(",", "."));  
    }

    public void pagarReserva(int valor) {
        this.valorPago = valor;
        System.out.println("Reserva paga");
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Funcionario getFuncionarioReserva() {
        return funcionarioReserva;
    }

    public void setFuncionarioReserva(Funcionario funcionarioReserva) {
        this.funcionarioReserva = funcionarioReserva;
    }

    public Funcionario getFuncionarioSaida() {
        return funcionarioSaida;
    }

    public void setFuncionarioSaida(Funcionario funcionarioSaida) {
        this.funcionarioSaida = funcionarioSaida;
    }

    public Date getDataEntradaReserva() {
        return dataEntradaReserva;
    }

    public void setDataEntradaReserva(Date dataEntradaReserva) {
        this.dataEntradaReserva = dataEntradaReserva;
    }

    public Date getDataSaidaReserva() {
        return dataSaidaReserva;
    }

    public void setDataSaidaReserva(Date dataSaidaReserva) {
        this.dataSaidaReserva = dataSaidaReserva;
    }

    public Date getDataCheckin() {
        return dataCheckin;
    }

    public void setDataCheckin(Date dataCheckin) {
        this.dataCheckin = dataCheckin;
    }

    public Date getDataCheckout() {
        return dataCheckout;
    }

    public void setDataCheckout(Date dataCheckout) {
        this.dataCheckout = dataCheckout;
    }

    public double getValorReserva() {
        return valorReserva;
    }

    public void setValorReserva(double valorReserva) {
        this.valorReserva = valorReserva;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }    
}
