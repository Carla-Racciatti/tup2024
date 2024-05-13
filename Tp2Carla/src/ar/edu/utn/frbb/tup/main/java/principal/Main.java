package principal;

import inputProcessors.MenuInputProcessor;
import entidades.Banco;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        MenuInputProcessor menuInputProcessor = new MenuInputProcessor();
        menuInputProcessor.renderMenu(banco);


    }
}