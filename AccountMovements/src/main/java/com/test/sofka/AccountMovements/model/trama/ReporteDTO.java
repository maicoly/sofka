package com.test.sofka.AccountMovements.model.trama;

import com.test.sofka.AccountMovements.model.entity.Movimiento;

import java.math.BigDecimal;
import java.util.List;

public class ReporteDTO {
    private String numeroCuenta;
    private BigDecimal saldoInicial;
    private List<ReporteMovimientos> movimientos;

    public ReporteDTO(String numeroCuenta, BigDecimal saldoInicial, List<ReporteMovimientos> movimientos) {
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

    public List<ReporteMovimientos> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<ReporteMovimientos> movimientos) {
        this.movimientos = movimientos;
    }
}
