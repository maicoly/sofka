package com.test.sofka.AccountMovements.model.trama;

import com.test.sofka.AccountMovements.model.entity.Movimiento;

import java.math.BigDecimal;
import java.util.List;

public class ReporteDTO {
    private String numeroCuenta;
    private String datosCliente;
    private BigDecimal saldoInicial;
    private List<ReporteMovimientos> movimientos;

    public ReporteDTO(String numeroCuenta, String datos, BigDecimal saldoInicial, List<ReporteMovimientos> movimientos) {
        this.numeroCuenta = numeroCuenta;
        this.datosCliente = datos;
        this.saldoInicial = saldoInicial;
        this.movimientos = movimientos;
    }

    public String getDatosCliente() {
        return datosCliente;
    }

    public void setDatosCliente(String datosCliente) {
        this.datosCliente = datosCliente;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public BigDecimal getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(BigDecimal saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public List<ReporteMovimientos> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<ReporteMovimientos> movimientos) {
        this.movimientos = movimientos;
    }
}
