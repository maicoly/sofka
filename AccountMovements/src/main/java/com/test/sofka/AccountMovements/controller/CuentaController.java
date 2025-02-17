package com.test.sofka.AccountMovements.controller;

import com.test.sofka.AccountMovements.model.entity.Cuenta;
import com.test.sofka.AccountMovements.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Main controller for CRUD account request
 *
 * @autor maicoly
 * @fecha 2025/02/16
 */
@RestController
@RequestMapping("cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @PostMapping
    public Mono<Cuenta> crearCuenta(@RequestBody Cuenta cuenta) {
        return cuentaService.createCuenta(cuenta);
    }

    @GetMapping("/{numeroCuenta}")
    public Mono<Cuenta> obtenerCuenta(@PathVariable String numeroCuenta) {
        return cuentaService.findByNumeroCuenta(numeroCuenta);
    }

    @DeleteMapping("/{nCuenta}")
    public void deleteCliente(@PathVariable String nCuenta) {
        cuentaService.deleteCliente(nCuenta);
    }

    @PutMapping("/{nCuenta}")
    public Mono<Cuenta> updateCliente(@PathVariable String nCuenta, @RequestBody Cuenta cuenta) {
        return cuentaService.actualizarCuenta(nCuenta, cuenta);
    }

    @GetMapping
    public Flux<Cuenta> getAllCuentas() {
        return cuentaService.getAllCuentas();
    }
}
