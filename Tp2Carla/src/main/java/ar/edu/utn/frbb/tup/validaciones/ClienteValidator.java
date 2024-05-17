package ar.edu.utn.frbb.tup.validaciones;

import ar.edu.utn.frbb.tup.entidades.Cliente;
import ar.edu.utn.frbb.tup.operaciones.TransaccionesCliente;

public class ClienteValidator {

    public boolean validarCliente(Cliente cliente) {
        // Verificar si el cliente ya existe en el sistema
        if (TransaccionesCliente.existeCliente(cliente)) {
            return false; // El cliente ya existe, no se puede agregar nuevamente
        }
        return true; // Cliente válido, se puede agregar al sistema
    }
}
