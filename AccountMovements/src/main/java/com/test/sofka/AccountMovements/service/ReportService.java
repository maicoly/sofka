package com.test.sofka.AccountMovements.service;

import com.test.sofka.AccountMovements.model.entity.Cuenta;
import com.test.sofka.AccountMovements.model.entity.Movimiento;
import com.test.sofka.AccountMovements.model.trama.ReporteDTO;
import com.test.sofka.AccountMovements.respository.CuentaRepository;
import com.test.sofka.AccountMovements.respository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {
    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private MovimientoRepository movimientoRepository;

    public List<ReporteDTO> generarReporte(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        // Obtenemos todas las cuentas
        List<Cuenta> cuentas = cuentaRepository.findAll();

        // Creamos una lista para los reportes
        List<ReporteDTO> reportes = new ArrayList<>();

        // Iteramos sobre las cuentas y generamos el reporte para cada una
        for (Cuenta cuenta : cuentas) {
            // Obtenemos los movimientos de la cuenta dentro del rango de fechas
            List<Movimiento> movimientos = movimientoRepository.findByCuentaAndFechaBetween(cuenta, fechaInicio, fechaFin);

            // Calculamos el saldo de la cuenta (puedes agregar lógica adicional aquí si es necesario)
            BigDecimal saldoTotal = cuenta.getSaldoInicial();

            // Creamos el DTO para el reporte
            ReporteDTO reporte = new ReporteDTO(cuenta.getNumeroCuenta(), saldoTotal, movimientos);

            // Añadimos el reporte a la lista
            reportes.add(reporte);
        }

        return reportes;
    }
}
