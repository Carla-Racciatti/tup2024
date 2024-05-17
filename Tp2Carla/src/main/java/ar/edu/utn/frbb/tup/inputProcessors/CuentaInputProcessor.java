package ar.edu.utn.frbb.tup.inputProcessors;

import ar.edu.utn.frbb.tup.entidades.Cliente;
import ar.edu.utn.frbb.tup.entidades.CuentaBancaria;
import ar.edu.utn.frbb.tup.entidades.MovimientoCuenta;
import ar.edu.utn.frbb.tup.operaciones.TransaccionesCliente;
import ar.edu.utn.frbb.tup.operaciones.TransaccionesCuenta;
import ar.edu.utn.frbb.tup.validaciones.ClienteValidator;
import ar.edu.utn.frbb.tup.validaciones.CuentaValidator;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class CuentaInputProcessor {
    private final TransaccionesCuenta transaccionesCuenta;
    private final CuentaValidator cuentaValidator;
    private final ClienteValidator clienteValidator;
    private final Scanner scanner;

    public CuentaInputProcessor() {
        this.transaccionesCuenta = new TransaccionesCuenta();
        this.cuentaValidator = new CuentaValidator();
        this.clienteValidator = new ClienteValidator();
        this.scanner = new Scanner(System.in);
    }

    public void crearCuenta() {
        System.out.println("Creación de Nueva Cuenta Bancaria");

        // Solicitar datos de la cuenta
        Cliente cliente = solicitarCliente();
        if (cliente == null) {
            return; // No se puede crear la cuenta sin un cliente válido
        }
        String tipoCuenta = solicitarDato("Tipo de Cuenta");
        double saldo = solicitarSaldo();
        LocalDate fechaApertura = LocalDate.now();

        // Generar número de cuenta automáticamente
        String numeroCuenta = generarNumeroCuenta();

        // Crear objeto CuentaBancaria con los datos ingresados
        CuentaBancaria nuevaCuenta = new CuentaBancaria(numeroCuenta, cliente, tipoCuenta, saldo, fechaApertura);

        // Validar cuenta antes de agregarla
        if (cuentaValidator.validarCuenta(nuevaCuenta)) {
            transaccionesCuenta.agregarCuenta(nuevaCuenta);
            System.out.println("Cuenta bancaria creada exitosamente:");
            System.out.println(nuevaCuenta);
        } else {
            System.out.println("No se pudo crear la cuenta bancaria.");
        }
    }

    private Cliente solicitarCliente() {
        System.out.print("Ingrese el ID del cliente: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después del número entero
        Cliente cliente = TransaccionesCliente.obtenerClientePorID(idCliente);
        if (cliente == null || !clienteValidator.validarCliente(cliente)) {
            System.out.println("El cliente no está registrado o es inválido. Por favor, registre al cliente primero.");
            return null;
        }
        return cliente;
    }

    private String solicitarDato(String mensaje) {
        System.out.print(mensaje + ": ");
        return scanner.nextLine();
    }

    private double solicitarSaldo() {
        double saldo;
        do {
            System.out.print("Saldo Inicial: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Saldo inválido. Por favor, ingrese un número.");
                System.out.print("Saldo Inicial: ");
                scanner.next();
            }
            saldo = scanner.nextDouble();
        } while (saldo < 0); // Asumiendo que un saldo válido no puede ser negativo
        scanner.nextLine(); // Consumir la nueva línea después del número doble
        return saldo;
    }

    private String generarNumeroCuenta() {
        return "CUENTA-" + System.currentTimeMillis(); // Generar número de cuenta único basado en el tiempo actual
    }

    public void consultarSaldo() {
        System.out.print("Ingrese el número de cuenta: ");
        String numeroCuenta = scanner.nextLine();
        double saldo = TransaccionesCuenta.consultarSaldo(numeroCuenta);
        System.out.println("Saldo de la cuenta " + numeroCuenta + ": " + saldo);
    }

    public void realizarDeposito() {
        System.out.print("Ingrese el número de cuenta: ");
        String numeroCuenta = scanner.nextLine();
        System.out.print("Ingrese el monto a depositar: ");
        double monto = scanner.nextDouble();
        // Llamo a TransaccionesCuenta.realizarDeposito() con los datos proporcionados por el usuario
    }

    public void realizarTransferencia() {
        System.out.print("Ingrese el número de cuenta de origen: ");
        String numeroCuentaOrigen = scanner.nextLine();
        System.out.print("Ingrese el número de cuenta de destino: ");
        String numeroCuentaDestino = scanner.nextLine();
        System.out.print("Ingrese el monto a transferir: ");
        double monto = scanner.nextDouble();
        // Llamo a TransaccionesCuenta.realizarTransferencia() con los datos proporcionados por el usuario
    }

    public void verHistorialMovimientos() {
        System.out.print("Ingrese el número de cuenta: ");
        String numeroCuenta = scanner.nextLine();
        List<MovimientoCuenta> movimientos = TransaccionesCuenta.obtenerMovimientos(numeroCuenta);
        if (movimientos != null) {
            System.out.println("Historial de movimientos de la cuenta " + numeroCuenta + ":");
            for (MovimientoCuenta movimiento : movimientos) {
                System.out.println(movimiento);
            }
        } else {
            System.out.println("No se encontraron movimientos para la cuenta " + numeroCuenta);
        }
    }

    public void cerrarScanner() {
        scanner.close();
    }


}

