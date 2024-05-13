package Principal;
import entidades.Banco;
import

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        MenuInputProcessor menuInputProcessor = new MenuInputProcessor();
        menuInputProcessor.renderMenu(banco);


    }
}