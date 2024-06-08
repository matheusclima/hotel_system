package domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import dao.Manager;

public class Reserva extends Generic {
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
        Manager manager = new Manager();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        this.codigo = Integer.parseInt(attr[0]);
        this.hospede.setCpf(attr[1]);
        this.hospede = manager.hospede.consultar(this.hospede);

        this.quarto.setCodigo(Integer.parseInt(attr[2]));
        this.quarto = manager.quarto.consultar(this.quarto);

        this.funcionarioReserva.setCpf(attr[3]);
        this.funcionarioReserva = manager.funcionario.consultar(this.funcionarioReserva);

        this.funcionarioSaida.setCpf(attr[4]);
        this.funcionarioSaida = manager.funcionario.consultar(this.funcionarioSaida);
        
        try {
            this.dataEntradaReserva = dateFormat.parse(attr[5]);
            this.dataEntradaReserva = dateFormat.parse(attr[6]);
            this.dataCheckin = dateFormat.parse(attr[7]);
            this.dataCheckout = dateFormat.parse(attr[8]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        this.valorPago = Double.parseDouble(attr[9].replace(",", "."));
        this.valorReserva = Double.parseDouble(attr[10].replace(",", "."));  
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return String.format("%d;%s;%d;%s;%s;%s;%s;%s;%s;%.2f;%.2f", codigo, hospede.getCpf(), quarto.getCodigo(), 
                                                funcionarioReserva.getCpf(), funcionarioSaida.getCpf(),
                                                df.format(dataEntradaReserva), df.format(dataSaidaReserva),
                                                df.format(dataCheckin), df.format(dataCheckout), valorReserva, valorPago);
    }

    @Override
    public String getId() {
        return Integer.toString(this.codigo);
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
