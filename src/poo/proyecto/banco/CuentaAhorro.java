/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.proyecto.banco;

/**
 *
 * @author hps
 */
public class CuentaAhorro extends CuentaBancaria {
    
    

    public double tasaInteresAnual;

    private int retirosRealizadosMes;
    private double comisionPorExceso = 20.0;

    public CuentaAhorro(String numeroCuenta, String titular, double saldoInicial, double tasaInteresAnual) {

        super(numeroCuenta, titular, saldoInicial);

        this.tasaInteresAnual = tasaInteresAnual;
        this.retirosRealizadosMes = 0;
    }

    public boolean retirarConComision(double monto) {

        if (monto <= 0) {
            System.out.println("El monto debe ser mayor a cero");
            return false;
        }

        double montoTotal = monto;

        if (this.retirosRealizadosMes >= 3) {
            montoTotal = monto + this.comisionPorExceso;
        }

        boolean retiroExitoso = this.retirar(montoTotal);

        if (retiroExitoso) {
            this.retirosRealizadosMes++;

            if (this.retirosRealizadosMes > 3) {
                System.out.println("Comision cobrada: L. "
                        + this.comisionPorExceso);
            }
        }

        return retiroExitoso;
    }

    public void aplicarInteresMensual() {

        if (this.tasaInteresAnual < 0) {
            System.out.println("La tasa de interes no puede ser negativa");
            return;
        }

        double interes = (this.getSaldo()
                * (this.tasaInteresAnual / 100)) / 12;

        System.out.println("Interes mensual: L. " + interes);

        this.depositar(interes);
    }
}


