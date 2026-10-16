/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo.proyecto.banco;

/**
 *
 * @author hps
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        System.out.println("===== CUENTA BANCARIA =====");

        CuentaBancaria miCuenta = new CuentaBancaria(
                "100200300", "Alejandro Cabrera", 1500);

       // Prueba de acceso directo a atributos publicos
System.out.println("Titular: " + miCuenta.titular);
System.out.println("Numero de cuenta: "+ miCuenta.numeroCuenta);
        // miCuenta.saldo = 50000;
// Esta línea genera un error porque saldo es private.
// Solo se puede consultar desde otra clase usando getSaldo().

        miCuenta.depositar(500);
        miCuenta.retirar(200);
        miCuenta.mostrarDatos();

        System.out.println("\n===== CUENTA DE AHORRO =====");

        CuentaAhorro ahorro = new CuentaAhorro(
                "AH-001", "Cliente Ahorro", 3000, 5);

        ahorro.retirarConComision(100);
        ahorro.retirarConComision(100);
        ahorro.retirarConComision(100);
        ahorro.retirarConComision(100);

        System.out.println("Saldo despues de los retiros: L. "
                + ahorro.getSaldo());

        System.out.println("\n===== INTERES MENSUAL =====");

        ahorro.aplicarInteresMensual();

        System.out.println("Saldo despues del interes: L. "
                + ahorro.getSaldo());

        System.out.println("\n===== CUENTA CORRIENTE =====");

        CuentaCorriente corriente = new CuentaCorriente(
                "CC-001", "Cliente Empresarial", 1000,
                "Empresa Demo", 5000);

        corriente.retirarConSobregiro(3500);

        System.out.println("Saldo actual: L. "
                + corriente.getSaldo());

        System.out.println("Sobregiro utilizado: L. "
                + corriente.getSobregiroUtilizado());

        System.out.println("\n===== PAGO DE SOBREGIRO =====");

        corriente.pagarSobregiro(1000);

        System.out.println("Deuda restante: L. "
                + corriente.getSobregiroUtilizado());

        System.out.println("Saldo final: L. "
                + corriente.getSaldo());
    }
}

    
    

