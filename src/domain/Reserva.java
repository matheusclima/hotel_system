package domain;

import java.util.Date;
import java.util.ArrayList;

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

    public boolean cadastrar(Reserva reserva) {
        // TODO
        return true;
    }

    public boolean editar(Reserva reserva) {
        // TODO
        return true;
    }

    public Reserva consultar(Reserva reserva) {
        // TODO
        return reserva;
    }

    public ArrayList<Reserva> listar(Reserva reserva) {
        // TODO
        return new ArrayList<Reserva>();
    }

    public void pagarReserva(int valor) {
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
