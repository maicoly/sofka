package com.test.sofka.AccountMovements.controller;

import com.test.sofka.AccountMovements.model.trama.ReporteDTO;
import com.test.sofka.AccountMovements.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


/**
 * Main controller for get report for movements
 *
 * @autor maicoly
 * @fecha 2025/02/16
 */
@RestController
@RequestMapping("/reportes")
public class ReporteController {
    @Autowired
    private ReportService reporteService;

    @GetMapping
    public ResponseEntity<List<ReporteDTO>> generarReporte(
            @RequestParam("fechaInicio") String fechaInicioStr,
            @RequestParam("fechaFin") String fechaFinStr) {

        // Convertir las fechas recibidas como parámetros de cadena a LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime fechaInicio = LocalDateTime.parse(fechaInicioStr, formatter);
        LocalDateTime fechaFin = LocalDateTime.parse(fechaFinStr, formatter);

        // Generar el reporte
        List<ReporteDTO> reportes = reporteService.generarReporte(fechaInicio, fechaFin);

        // Devolver el reporte con un código de estado 200 OK
        return ResponseEntity.ok(reportes);
    }
}
