package com.test.sofka.AccountMovements.model.trama;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
public class ReporteMovimientos {
    private LocalDateTime fecha;
    private String tipoMovimiento;
    private BigDecimal valor;

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
