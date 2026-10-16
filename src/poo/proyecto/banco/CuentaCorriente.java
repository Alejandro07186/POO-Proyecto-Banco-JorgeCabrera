/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.proyecto.banco;

/**
 *
 * @author hps
 */
public class CuentaCorriente extends CuentaBancaria{

    public String nombreEmpresa;

    private double limiteSobregiro;
    private double sobregiroUtilizado;

    public CuentaCorriente(String numeroCuenta, String titular,double saldoInicial, String nombreEmpresa,
                           double limiteSobregiro) {

        super(numeroCuenta, titular, saldoInicial);

        this.nombreEmpresa = nombreEmpresa;
        this.limiteSobregiro = limiteSobregiro;
        this.sobregiroUtilizado = 0.0;
    }

    public double getLimiteSobregiro() {
        return this.limiteSobregiro;
    }

    public double getSobregiroUtilizado() {
        return this.sobregiroUtilizado;
    }

    public boolean retirarConSobregiro(double monto) {

        if (monto <= 0) {
            System.out.println("El monto debe ser mayor a cero");
            return false;
        }

        if (this.getSaldo() >= monto) {
            return this.retirar(monto);
        }

        double diferencia = monto - this.getSaldo();
        double recargo = diferencia * 0.03;

        double deudaNueva = this.sobregiroUtilizado
                + diferencia + recargo;

        if (deudaNueva > this.limiteSobregiro) {
            System.out.println("Sobregiro excede el limite autorizado");
            return false;
        }

        double saldoDisponible = this.getSaldo();

        if (saldoDisponible > 0) {
            this.retirar(saldoDisponible);
        }

        this.sobregiroUtilizado = this.sobregiroUtilizado
                + diferencia + recargo;

        System.out.println("Credito utilizado: L. " + diferencia);
        System.out.println("Recargo del 3%: L. " + recargo);

        System.out.println("Deuda total: L. "
                + this.sobregiroUtilizado);

        return true;
    }

    public void pagarSobregiro(double monto) {

        if (monto <= 0) {
            System.out.println("El abono debe ser mayor a cero");
            return;
        }

        if (this.sobregiroUtilizado == 0) {
            System.out.println("No hay deuda pendiente");
            this.depositar(monto);
            return;
        }

        double pago;

        if (monto > this.sobregiroUtilizado) {
            pago = this.sobregiroUtilizado;
        } else {
            pago = monto;
        }

        this.sobregiroUtilizado = this.sobregiroUtilizado - pago;

        System.out.println("Abono realizado: L. " + pago);

        double sobrante = monto - pago;

        if (sobrante > 0) {
            this.depositar(sobrante);
            System.out.println("Dinero sobrante agregado al saldo: L. "
                    + sobrante);
        }
    }
}

    

