package ar.edu.utn.frbb.tup.entidades;

import java.time.LocalDate;

public class Cliente extends Persona {
    //el resto de los atributos los hereda de la clase Persona.
    private int id;


    // Constructor
    public Cliente(int id, String nombre, String apellido, String direccion, String telefono, long dni, LocalDate fechaNacimiento) {
        super(nombre, apellido, direccion, telefono, dni, fechaNacimiento);
        this.id = id;
    }

    // Getter y Setter para el atributo id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Método toString que incluye el id
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", dni=" + dni +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}


/*
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Cliente extends Persona{
    private int id; //agrego atributo

    private TipoPersona tipoPersona;
    private String banco;
    private LocalDate fechaAlta;
    private Set<Cuenta> cuentas = new HashSet<>();

     //agrego getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Set<Cuenta> getCuentas() {
        return cuentas;
    }

    public void addCuenta(Cuenta cuenta) {
        this.cuentas.add(cuenta);
    }
}

*/