/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.proyecto.banco;

/**
 *
 * @author hps
 */
public class CuentaBancaria {
   

    public String numeroCuenta;
    public String titular;

    private double saldo;
    private int totalTransacciones;

    public CuentaBancaria(String numeroCuenta, String titular,double saldoInicial) {

        this.numeroCuenta = numeroCuenta;
        this.titular = titular;

        if (saldoInicial < 0) {
            this.saldo = 0.0;
        } else {
            this.saldo = saldoInicial;
        }

        this.totalTransacciones = 0;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public int getTotalTransacciones() {
        return this.totalTransacciones;
    }

    public void depositar(double monto) {

        if (monto > 0) {
            this.saldo = this.saldo + monto;
            this.totalTransacciones++;

            System.out.println("Deposito exitoso: L. " + monto);
        } else {
            System.out.println("El monto debe ser mayor a cero");
        }
    }

    public boolean retirar(double monto) {

        if (monto <= 0) {
            System.out.println("El monto debe ser mayor a cero");
            return false;
        }

        if (monto > this.saldo) {
            System.out.println("Fondos insuficientes");
            return false;
        }

        this.saldo = this.saldo - monto;
        this.totalTransacciones++;

        System.out.println("Retiro exitoso: L. " + monto);

        return true;
    }

    public void mostrarDatos() {

        System.out.println("Titular: " + this.titular);
        System.out.println("Numero de cuenta: " + this.numeroCuenta);
        System.out.println("Saldo actual: L. " + this.saldo);

        System.out.println("Total de transacciones: "
                + this.totalTransacciones);
    }
}

