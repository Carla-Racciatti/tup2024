package ar.edu.utn.frbb.tup.validaciones;

import ar.edu.utn.frbb.tup.entidades.CuentaBancaria;
import ar.edu.utn.frbb.tup.operaciones.TransaccionesCuenta;

public class CuentaValidator {
    private final ClienteValidator clienteValidator;

    public CuentaValidator() {
        this.clienteValidator = new ClienteValidator();
    }

    public boolean validarCuenta(CuentaBancaria cuenta) {
        if (existeCuenta(cuenta.getNumeroCuenta())) {
            System.out.println("El número de cuenta ya existe.");
            return false;
        }
        if (!clienteValidator.validarCliente(cuenta.getCliente())) {
            System.out.println("El cliente no está registrado o es inválido. Por favor, registre al cliente primero.");
            return false;
        }
        return true;
    }

    private boolean existeCuenta(String numeroCuenta) {
        for (CuentaBancaria cuentaExistente : TransaccionesCuenta.obtenerCuentas()) {
            if (cuentaExistente.getNumeroCuenta().equals(numeroCuenta)) {
                return true;
            }
        }
        return false;
    }
}





