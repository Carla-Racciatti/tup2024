package ar.edu.utn.frbb.tup.entidades;

import java.time.LocalDateTime;

public class MovimientoCuenta {
    private LocalDateTime fechaHora;
    private String tipoOperacion;
    private double monto;

    public MovimientoCuenta(LocalDateTime fechaHora, String tipoOperacion, double monto) {
        this.fechaHora = fechaHora;
        this.tipoOperacion = tipoOperacion;
        this.monto = monto;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public double getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return "MovimientoCuenta{" +
                "fechaHora=" + fechaHora +
                ", tipoOperacion='" + tipoOperacion + '\'' +
                ", monto=" + monto +
                '}';
    }
}
