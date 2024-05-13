package principal;

import InputProcessors.MenuInputProcessor;
import entidades.Banco;
import entidades.Cliente;
import entidades.TipoPersona;
import entidades.Cuenta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        MenuInputProcessor menuInputProcessor = new MenuInputProcessor();
        menuInputProcessor.renderMenu(banco);


    }
}