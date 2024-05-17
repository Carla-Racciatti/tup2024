package ar.edu.utn.frbb.tup.inputProcessors;
/* Esta clase maneja la entrada de datos sobre el cliente y crea un objeto Cliente con los datos ingresados.
 Además, se realizan algunas validaciones básicas de la capa de "presentación",
 como verificar que el DNI sea un número positivo y que la fecha de nacimiento no sea en el futuro.
 Luego, se llama a la clase ClienteValidator para validar cosas más "profundas",
 por ejemplo chequear si el cliente ya existe en la lista antes de agregarlo al sistema.*/

import ar.edu.utn.frbb.tup.entidades.Cliente;
import ar.edu.utn.frbb.tup.operaciones.TransaccionesCliente;
import ar.edu.utn.frbb.tup.validaciones.ClienteValidator;

import java.time.LocalDate;
import java.util.Scanner;

public class ClienteInputProcessor {
    private final TransaccionesCliente transaccionesCliente;
    private final ClienteValidator clienteValidator;
    private final Scanner scanner;

    public ClienteInputProcessor() {
        this.transaccionesCliente = new TransaccionesCliente();
        this.clienteValidator = new ClienteValidator();
        this.scanner = new Scanner(System.in);
    }

    //PARA CREAR UN NUEVO CLIENTE:
    public void crearCliente() {
        System.out.println("Creación de Nuevo Cliente");

        // Solicitar datos del cliente
        String nombre = solicitarDato("Nombre");
        String apellido = solicitarDato("Apellido");
        String direccion = solicitarDato("Dirección");
        String telefono = solicitarDato("Número de Teléfono");
        long dni = solicitarDNI();
        LocalDate fechaNacimiento = solicitarFechaNacimiento();

        // Creo objeto Cliente con los datos ingresados
        //envio id cero porque en la clase de TransaccionesCliente se le asignará automáticamente su id correspondiente
        Cliente nuevoCliente = new Cliente(0,nombre, apellido, direccion, telefono, dni, fechaNacimiento);

        // Validar cliente antes de agregarlo
        if (clienteValidator.validarCliente(nuevoCliente)) {
            // Agregar el cliente al sistema utilizando TransaccionesCliente
            transaccionesCliente.agregarCliente(nuevoCliente);
            //imprimo en pantalla mensaje de exito:
            System.out.println(" . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . ");
            System.out.println("Se ha agregado exitosamente el cliente con los siguientes datos: ");
            System.out.println(nuevoCliente);
            System.out.println(" . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . ");
        } else {
            System.out.println("El cliente ya existe en el sistema.");
        }
    }


    //PARA MODIFICAR UN CLIENTE YA EXISTENTE:

    public void modificarCliente() {
        System.out.println("Modificación de Cliente");

        // Solicitar ID del cliente a modificar
        int idCliente = solicitarIDCliente();

        // Verificar si el cliente existe
        Cliente clienteExistente = transaccionesCliente.obtenerClientePorID(idCliente);
        if (clienteExistente != null) {
            // Solicitar datos actualizados del cliente
            String nombre = solicitarDato("Nombre");
            String apellido = solicitarDato("Apellido");
            String direccion = solicitarDato("Dirección");
            String telefono = solicitarDato("Número de Teléfono");
            long dni = solicitarDNI();
            LocalDate fechaNacimiento = solicitarFechaNacimiento();

            // Actualizar datos del cliente existente
            clienteExistente.setNombre(nombre);
            clienteExistente.setApellido(apellido);
            clienteExistente.setDireccion(direccion);
            clienteExistente.setTelefono(telefono);
            clienteExistente.setDni(dni);
            clienteExistente.setFechaNacimiento(fechaNacimiento);

            System.out.println("Cliente modificado exitosamente.");
        } else {
            System.out.println("El cliente con ID " + idCliente + " no existe en el sistema.");
        }
    }

    private int solicitarIDCliente() {
        int idCliente;
        do {
            System.out.print("Ingrese el ID del cliente a modificar: ");
            while (!scanner.hasNextInt()) {
                System.out.println("ID inválido. Por favor, ingrese un número.");
                System.out.print("Ingrese el ID del cliente a modificar: ");
                scanner.next();
            }
            idCliente = scanner.nextInt();
        } while (idCliente <= 0); // Se asume que un ID válido debe ser un número positivo
        scanner.nextLine(); // Consumir la nueva línea después del número entero
        return idCliente;
    }



    private String solicitarDato(String mensaje) {
        System.out.print(mensaje + ": ");
        return scanner.nextLine();
    }


    //En esta capa incluyo validaciones básicas de "presentacion", como el DNI y la fecha de nacimiento
    private long solicitarDNI() {
        long dni;
        do {
            System.out.print("DNI: ");
            while (!scanner.hasNextLong()) {
                System.out.println("DNI inválido. Por favor, ingrese un número.");
                System.out.print("DNI: ");
                scanner.next();
            }
            dni = scanner.nextLong();
        } while (dni <= 0); // Asumiendo que un DNI válido debe ser un número positivo
        scanner.nextLine();
        return dni;
    }

    private LocalDate solicitarFechaNacimiento() {
        LocalDate fechaNacimiento;
        do {
            System.out.print("Fecha de Nacimiento (AAAA-MM-DD): ");
            while (!scanner.hasNextLine()) {
                System.out.println("Fecha de Nacimiento inválida. Por favor, ingrese una fecha en el formato correcto (AAAA-MM-DD).");
                System.out.print("Fecha de Nacimiento (AAAA-MM-DD): ");
                scanner.next();
            }
            fechaNacimiento = LocalDate.parse(scanner.nextLine());
        } while (fechaNacimiento.isAfter(LocalDate.now())); // la fecha de nacimiento no puede ser en el futuro
        return fechaNacimiento;
    }

    public void eliminarCliente() {
        System.out.println("Eliminación de Cliente");

        // Solicitar ID del cliente a eliminar
        int idCliente = solicitarIDCliente();

        // Verificar si el cliente existe
        Cliente clienteExistente = transaccionesCliente.obtenerClientePorID(idCliente);
        if (clienteExistente != null && clienteValidator.validarCliente(clienteExistente)) {
            // Eliminar el cliente
            transaccionesCliente.eliminarCliente(clienteExistente);
            System.out.println("Cliente eliminado exitosamente.");
        } else {
            System.out.println("El cliente con ID " + idCliente + " no existe en el sistema o es inválido.");
        }
    }

    public void cerrarScanner() {
        scanner.close();
    }
}


/*
import entidades.Cliente;
import negocio.TransaccionesCliente;
import validaciones.ClienteValidator;

import java.time.LocalDate;
import java.util.Scanner;

public class ClienteInputProcessor {
    private final TransaccionesCliente transaccionesCliente;
    private final ClienteValidator clienteValidator;
    private final Scanner scanner;
    private static int proximoID = 0; //Voy a usar un contador para generar el ID del nuevo cliente automáticamente

    public ClienteInputProcessor() {
        this.transaccionesCliente = new TransaccionesCliente();
        this.clienteValidator = new ClienteValidator();
        this.scanner = new Scanner(System.in);
    }

    public void crearCliente() {
        System.out.println("Creación de Nuevo Cliente");

        // Generar ID único para el cliente
        int idCliente = generarIDCliente();

        // Solicito datos del cliente
        String nombre = solicitarDato("Nombre");
        String apellido = solicitarDato("Apellido");
        String direccion = solicitarDato("Dirección");
        String telefono = solicitarDato("Número de Teléfono");
        long dni = solicitarDNI();
        LocalDate fechaNacimiento = solicitarFechaNacimiento();

        // Crear objeto Cliente con los datos ingresados
        Cliente nuevoCliente = new Cliente(idCliente, nombre, apellido, direccion, telefono, dni, fechaNacimiento);

        // Validar cliente antes de agregarlo
        if (clienteValidator.validarCliente(nuevoCliente)) {
            // Agregar el cliente al sistema utilizando TransaccionesCliente
            transaccionesCliente.agregarCliente(nuevoCliente);
        } else {
            System.out.println("El cliente ya existe en el sistema.");
        }
    }

    private int generarIDCliente() {
        return proximoID++;
    }

    private String solicitarDato(String mensaje) {
        System.out.print(mensaje + ": ");
        return scanner.nextLine();
    }


    //En esta capa incluyo validaciones básicas de "presentacion", como el DNI y la fecha de nacimiento
    private long solicitarDNI() {
        long dni;
        do {
            System.out.print("DNI: ");
            while (!scanner.hasNextLong()) {
                System.out.println("DNI inválido. Por favor, ingrese un número.");
                System.out.print("DNI: ");
                scanner.next();
            }
            dni = scanner.nextLong();
        } while (dni <= 0); // Asumiendo que un DNI válido debe ser un número positivo
        scanner.nextLine();
        return dni;
    }

    private LocalDate solicitarFechaNacimiento() {
        LocalDate fechaNacimiento;
        do {
            System.out.print("Fecha de Nacimiento (AAAA-MM-DD): ");
            while (!scanner.hasNextLine()) {
                System.out.println("Fecha de Nacimiento inválida. Por favor, ingrese una fecha en el formato correcto (AAAA-MM-DD).");
                System.out.print("Fecha de Nacimiento (AAAA-MM-DD): ");
                scanner.next();
            }
            fechaNacimiento = LocalDate.parse(scanner.nextLine());
        } while (fechaNacimiento.isAfter(LocalDate.now())); // Se asume que la fecha de nacimiento no puede ser en el futuro
        return fechaNacimiento;
    }

    public void cerrarScanner() {
        scanner.close();
    }
}



/*
import entidades.Cliente;
import entidades.TipoPersona;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

    public class ClienteInputProcessor extends BaseInputProcessor{

        private static List<Cliente> clientes = new ArrayList<>();

        public Cliente ingresarCliente() {

            // Ingreso de datos del Cliente
            Cliente cliente = new Cliente();
            clearScreen();



            System.out.println("Ingrese el nombre del cliente:");
            String nombre = scanner.nextLine();
            cliente.setNombre(nombre);

            System.out.println("Ingrese el apellido del cliente:");
            String apellido = scanner.nextLine();
            cliente.setApellido(apellido);

            System.out.println("Ingrese el tipo de persona Física(F) o Jurídica(J):");
            String tipoPersonaStr = scanner.nextLine().toUpperCase();
            while (!tipoPersonaStr.equals("F") && !tipoPersonaStr.equals("J")) {
                System.out.println("Tipo de persona inválido. Ingrese NATURAL o JURIDICA:");
                tipoPersonaStr = scanner.nextLine().toUpperCase();
            }
            TipoPersona tipoPersona = TipoPersona.fromString(tipoPersonaStr);
            cliente.setTipoPersona(tipoPersona);

            System.out.println("Ingrese el banco del cliente:");
            String banco = scanner.nextLine();
            cliente.setBanco(banco);

            System.out.println("Ingrese la fecha de alta del cliente (Formato: YYYY-MM-DD):");
            LocalDate fechaAlta = null;
            boolean fechaValida = false;
            while (!fechaValida) {
                try {
                    fechaAlta = LocalDate.parse(scanner.nextLine());
                    fechaValida = true;
                } catch (Exception e) {
                    System.out.println("Formato de fecha inválido. Ingrese la fecha en formato YYYY-MM-DD:");
                }

                scanner.close();
            }
            cliente.setFechaAlta(fechaAlta);

            clearScreen();
            return cliente;

        }

        //Agrego método para modificar clinte existente:
        public Cliente modificarCliente(Cliente cliente) {
            clearScreen();
            System.out.println("Modificación del cliente:");

            System.out.println("Ingrese el nuevo nombre del cliente:");
            cliente.setNombre(scanner.nextLine());

            System.out.println("Ingrese el nuevo apellido del cliente:");
            cliente.setApellido(scanner.nextLine());

            System.out.println("Ingrese el nuevo tipo de persona Física(F) o Jurídica(J):");
            String tipoPersonaStr = scanner.nextLine().toUpperCase();
            while (!tipoPersonaStr.equals("F") && !tipoPersonaStr.equals("J")) {
                System.out.println("Tipo de persona inválido. Ingrese NATURAL o JURIDICA:");
                tipoPersonaStr = scanner.nextLine().toUpperCase();
            }
            TipoPersona tipoPersona = TipoPersona.fromString(tipoPersonaStr);
            cliente.setTipoPersona(tipoPersona);

            System.out.println("Ingrese el nuevo banco del cliente:");
            cliente.setBanco(scanner.nextLine());

            System.out.println("Ingrese la nueva fecha de alta del cliente (Formato: YYYY-MM-DD):");
            LocalDate fechaAlta = null;
            boolean fechaValida = false;
            while (!fechaValida) {
                try {
                    fechaAlta = LocalDate.parse(scanner.nextLine());
                    fechaValida = true;
                } catch (Exception e) {
                    System.out.println("Formato de fecha inválido. Ingrese la fecha en formato YYYY-MM-DD:");
                }
                scanner.close();
            }
            cliente.setFechaAlta(fechaAlta);

            clearScreen();
            return cliente;
        }
    }
*/

