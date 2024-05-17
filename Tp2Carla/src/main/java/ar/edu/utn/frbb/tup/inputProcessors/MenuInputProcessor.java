package ar.edu.utn.frbb.tup.inputProcessors;

import ar.edu.utn.frbb.tup.operaciones.TransaccionesCliente;

import java.util.Scanner;

import java.util.Scanner;

public class MenuInputProcessor {
    private final ClienteInputProcessor clienteInputProcessor;
    private final CuentaInputProcessor cuentaInputProcessor;
    private final Scanner scanner;

    public MenuInputProcessor() {
        this.clienteInputProcessor = new ClienteInputProcessor();
        this.cuentaInputProcessor = new CuentaInputProcessor();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        boolean salir = false;
        while (!salir) {
            System.out.println("==============================");
            System.out.println("=== Bienvenido al sistema bancario.===");
            System.out.println("=== Ingrese el número de la transacción que desea realizar: ===");
            System.out.println("1. Crear Cliente");
            System.out.println("2. Modificar Cliente");
            System.out.println("3. Eliminar Cliente");
            System.out.println("4. Mostrar Lista de Clientes");
            System.out.println("5. Crear Cuenta");
            System.out.println("6. Consultar Saldo");
            System.out.println("7. Realizar Depósito");
            System.out.println("8. Realizar Transferencia");
            System.out.println("9. Ver historial de movimientos");
            System.out.println("10. Salir");
            System.out.println("==============================");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    clienteInputProcessor.crearCliente();
                    break;
                case 2:
                    clienteInputProcessor.modificarCliente();
                    break;
                case 3:
                    clienteInputProcessor.eliminarCliente();
                    break;
                case 4:
                    TransaccionesCliente.mostrarListaClientes();
                    break;
                case 5:
                    cuentaInputProcessor.crearCuenta();
                    break;
                case 6:
                    cuentaInputProcessor.consultarSaldo();
                    break;
                case 7:
                    cuentaInputProcessor.realizarDeposito();
                    break;
                case 8:
                    cuentaInputProcessor.realizarTransferencia();
                    break;
                case 9:
                    cuentaInputProcessor.verHistorialMovimientos();
                    break;
                case 10:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }
}

