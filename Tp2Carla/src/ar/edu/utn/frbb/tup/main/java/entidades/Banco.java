package entidades;
import entidades.Cliente;
import inputProcessors.ClienteInputProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Banco {
        private List<Cliente> clientes = new ArrayList<>();

        private ClienteInputProcessor clienteInputProcessor = new ClienteInputProcessor(); //creo instancia de la clase ClienteInputProcessor
        public List<Cliente> getClientes() {
            return clientes;
        }

        public void setClientes(List<Cliente> clientes) {
            this.clientes = clientes;
        }

        //Para buscar cliente por su id
        public Cliente buscarClientePorId(int id) {
            for (Cliente cliente : clientes) {
                if (cliente.getId() == id) {
                    return cliente;
                }
            }
            return null; // Retorna null si no se encuentra ningún cliente con el ID especificado
        }


        //Para ingresar o generar nuevos clientes usando el metodo ingresarCliente de la clase ClienteInputProcessor:
        public void crearNuevoCliente() {
            Cliente cliente = clienteInputProcessor.ingresarCliente();
            clientes.add(cliente);
            System.out.println("Cliente creado exitosamente.");
        }

        //Para modificar cliente existente usando el metodo modificarCliente de ClienteInputProcessor:



}

