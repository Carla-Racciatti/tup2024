package ar.edu.utn.frbb.tup.operaciones;

import ar.edu.utn.frbb.tup.entidades.CuentaBancaria;
import ar.edu.utn.frbb.tup.entidades.MovimientoCuenta;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class TransaccionesCuenta {
    private static List<CuentaBancaria> listaCuentas = new ArrayList<>();

    public static void agregarCuenta(CuentaBancaria cuenta) {
        listaCuentas.add(cuenta);
    }

    public static List<CuentaBancaria> obtenerCuentas() {
        return listaCuentas;
    }

    public static CuentaBancaria obtenerCuentaPorNumero(String numeroCuenta) {
        for (CuentaBancaria cuenta : listaCuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

    public static double consultarSaldo(String numeroCuenta) {
        CuentaBancaria cuenta = obtenerCuentaPorNumero(numeroCuenta);
        if (cuenta != null) {
            return cuenta.getSaldo();
        } else {
            System.out.println("La cuenta con número " + numeroCuenta + " no existe.");
            return 0.0;
        }
    }

    public static void realizarDeposito(CuentaBancaria cuenta, double monto) {
        cuenta.setSaldo(cuenta.getSaldo() + monto);
        MovimientoCuenta movimiento = new MovimientoCuenta(LocalDateTime.now(), "Depósito", monto);
        cuenta.agregarMovimiento(movimiento);
    }

    public static void realizarRetiro(CuentaBancaria cuenta, double monto) {
        if (cuenta.getSaldo() >= monto) {
            cuenta.setSaldo(cuenta.getSaldo() - monto);
            MovimientoCuenta movimiento = new MovimientoCuenta(LocalDateTime.now(), "Retiro", monto);
            cuenta.agregarMovimiento(movimiento);
        } else {
            System.out.println("Saldo insuficiente para realizar el retiro.");
        }
    }

    public static void realizarTransferencia(CuentaBancaria origen, CuentaBancaria destino, double monto) {
        if (origen.getSaldo() >= monto) {
            origen.setSaldo(origen.getSaldo() - monto);
            destino.setSaldo(destino.getSaldo() + monto);
            MovimientoCuenta movimientoOrigen = new MovimientoCuenta(LocalDateTime.now(), "Transferencia enviada", -monto);
            MovimientoCuenta movimientoDestino = new MovimientoCuenta(LocalDateTime.now(), "Transferencia recibida", monto);
            origen.agregarMovimiento(movimientoOrigen);
            destino.agregarMovimiento(movimientoDestino);
        } else {
            System.out.println("Saldo insuficiente para realizar la transferencia.");
        }
    }

    public static List<MovimientoCuenta> obtenerMovimientos(String numeroCuenta) {
        CuentaBancaria cuenta = obtenerCuentaPorNumero(numeroCuenta);
        if (cuenta != null) {
            return cuenta.getHistorialMovimientos();
        } else {
            System.out.println("La cuenta con número " + numeroCuenta + " no existe.");
            return null;
        }
    }

}
