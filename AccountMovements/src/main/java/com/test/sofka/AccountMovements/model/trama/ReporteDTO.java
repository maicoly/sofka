package com.test.sofka.AccountMovements.model.trama;

import com.test.sofka.AccountMovements.model.entity.Movimiento;

import java.math.BigDecimal;
import java.util.List;

public class ReporteDTO {
    private String numeroCuenta;
    private BigDecimal saldoInicial;
    private List<Movimiento> movimientos;

    public ReporteDTO(String numeroCuenta, BigDecimal saldoInicial, List<Movimiento> movimientos) {
        this.numeroCuenta = numeroCuenta;
        this.saldoInicial = saldoInicial;
        this.movimientos = movimientos;
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

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }
}
