package ar.edu.utn.frbb.tup.operaciones;

import ar.edu.utn.frbb.tup.entidades.Cliente;

import java.util.ArrayList;
import java.util.List;

public class TransaccionesCliente {
    private static List<Cliente> listaClientes = new ArrayList<>();
    private static int proximoID = 1;

    public static void agregarCliente(Cliente cliente) {
        cliente.setId(proximoID++);
        listaClientes.add(cliente);
    }

    public static void eliminarCliente(Cliente cliente) {
        listaClientes.remove(cliente);
    }

    public static boolean existeCliente(Cliente cliente) {
        for (Cliente c : listaClientes) {
            if (c.getNombre().equalsIgnoreCase(cliente.getNombre()) &&
                    c.getApellido().equalsIgnoreCase(cliente.getApellido()) &&
                    c.getDni() == cliente.getDni() &&
                    c.getFechaNacimiento().isEqual(cliente.getFechaNacimiento())) {
                return true; // El cliente ya existe en la lista
            }
        }
        return false; // El cliente no existe en la lista
    }

    public static Cliente obtenerClientePorID(int idCliente) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == idCliente) {
                return cliente; // Devuelve el cliente si se encuentra en la lista
            }
        }
        return null; // Devuelve null si no se encuentra el cliente
    }

    //Decidí agregar un método para mostrar toda la lista de clientes
    public static void mostrarListaClientes() {
        System.out.println("Lista de Clientes:");
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
            System.out.println("__________________________________");
        }

    }
}



