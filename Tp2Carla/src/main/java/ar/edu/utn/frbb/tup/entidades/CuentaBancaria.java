package ar.edu.utn.frbb.tup.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {
    private String numeroCuenta;
    private Cliente cliente;
    private String tipoCuenta;
    private double saldo;
    private LocalDate fechaApertura;
    private List<MovimientoCuenta> historialMovimientos;

    public CuentaBancaria(String numeroCuenta, Cliente cliente, String tipoCuenta, double saldo, LocalDate fechaApertura) {
        this.numeroCuenta = numeroCuenta;
        this.cliente = cliente;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
        this.historialMovimientos = new ArrayList<>();
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public List<MovimientoCuenta> getHistorialMovimientos() {
        return historialMovimientos;
    }

    public void agregarMovimiento(MovimientoCuenta movimiento) {
        historialMovimientos.add(movimiento);
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", cliente=" + cliente +
                ", tipoCuenta='" + tipoCuenta + '\'' +
                ", saldo=" + saldo +
                ", fechaApertura=" + fechaApertura +
                ", historialMovimientos=" + historialMovimientos +
                '}';
    }
}
