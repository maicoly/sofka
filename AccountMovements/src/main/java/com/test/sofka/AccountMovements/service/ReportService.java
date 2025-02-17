package com.test.sofka.AccountMovements.service;

import com.test.sofka.AccountMovements.model.entity.Cuenta;
import com.test.sofka.AccountMovements.model.entity.Movimiento;
import com.test.sofka.AccountMovements.model.trama.ReporteDTO;
import com.test.sofka.AccountMovements.model.trama.ReporteMovimientos;
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
        List<Cuenta> cuentas = cuentaRepository.findAll();

        List<ReporteDTO> reportes = new ArrayList<>();

        for (Cuenta cuenta : cuentas) {
            List<Movimiento> movimientos = movimientoRepository.findByCuentaAndFechaBetween(cuenta, fechaInicio, fechaFin);
            BigDecimal saldoTotal = cuenta.getSaldoInicial();
            List<ReporteMovimientos> repMovs = new ArrayList<>();
            for(Movimiento mov: movimientos){
                ReporteMovimientos rep = new ReporteMovimientos();
                rep.setValor(mov.getValor());
                rep.setFecha(mov.getFecha());
                rep.setTipoMovimiento(mov.getTipoMovimiento());
                repMovs.add(rep);
            }
            ReporteDTO reporte = new ReporteDTO(cuenta.getNumeroCuenta(), saldoTotal, repMovs);
            reportes.add(reporte);
        }

        return reportes;
    }
}
