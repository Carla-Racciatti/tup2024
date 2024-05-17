package ar.edu.utn.frbb.tup;

import ar.edu.utn.frbb.tup.inputProcessors.MenuInputProcessor;
import ar.edu.utn.frbb.tup.inputProcessors.ClienteInputProcessor;

public class Main {
    public static void main(String[] args) {
        // Crear instancia de MenuInputProcessor para mostrar el menú
        MenuInputProcessor menuInputProcessor = new MenuInputProcessor();
        ClienteInputProcessor clienteInputProcessor = new ClienteInputProcessor();

        // Mostrar el menú
        menuInputProcessor.mostrarMenu();
    }
}
