package InputProcessors;
import entidades.Banco;
import entidades.Cliente;

import java.util.Scanner;

public class MenuInputProcessor extends BaseInputProcessor{
    ClienteInputProcessor clienteInputProcessor = new ClienteInputProcessor();
    boolean exit = false;

    Scanner scanner = new Scanner(System.in);

    public void renderMenu(Banco banco) {

        while (!exit) {
            System.out.println("Bienveido a la aplicación de Banco!");
            System.out.print("¿Qué desea hacer? Ingrese una opción (1-4): ");
            System.out.println("1. Crear un nuevo Cliente");
            System.out.println("2. Crear una nueva Cuenta");
            System.out.println("3. Generar un movimiento");
            System.out.println("4. Salir");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
 //           case 1:
   //             Cliente c = clienteInputProcessor.ingresarCliente();
     //           banco.getClientes().add(c);
       //         break;
//            case 2:
//                createAccount();
//                break;
//            case 3:
//                performTransaction();
//                break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor seleccione un número entre las opciones 1 a 4.");
            }
            clearScreen();
        }
        scanner.close();
    }
}

