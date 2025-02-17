package com.test.sofka.AccountMovements.controller;

import com.test.sofka.AccountMovements.model.entity.Movimiento;
import com.test.sofka.AccountMovements.model.trama.MovimientoRequest;
import com.test.sofka.AccountMovements.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * Main controller for CRUD movements request
 *
 * @autor maicoly
 * @fecha 2025/02/16
 */
@RestController
@RequestMapping("movimientos")
public class MovimientosController {

    @Autowired
    private MovimientoService movimientoService;

    @PostMapping
    public Mono<Movimiento> realizarMovimiento(@RequestBody MovimientoRequest movimientoRequest) {
        return movimientoService.realizarMovimiento(movimientoRequest.getNumeroCuenta(), movimientoRequest.getMonto());
    }

}
