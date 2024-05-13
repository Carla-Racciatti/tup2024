package inputProcessors;

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

            // Genero un nuevo ID único para el cliente
           // int nuevoId = generarNuevoId();
            // cliente.setId(nuevoId);

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


