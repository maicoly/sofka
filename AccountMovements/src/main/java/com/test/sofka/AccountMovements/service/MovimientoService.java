package com.test.sofka.AccountMovements.service;

import com.test.sofka.AccountMovements.exception.CustomException;
import com.test.sofka.AccountMovements.model.entity.Cuenta;
import com.test.sofka.AccountMovements.model.entity.Movimiento;
import com.test.sofka.AccountMovements.respository.CuentaRepository;
import com.test.sofka.AccountMovements.respository.MovimientoRepository;
import com.test.sofka.AccountMovements.utils.ErrorMessages;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Client Service
 *
 * @autor maicoly
 * @fecha 2025/02/16
 */
@Service
public class MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Transactional
    public Mono<Movimiento> realizarMovimiento(String numeroCuenta, Double monto) {
        Mono<Cuenta> cuentaMono = Mono.justOrEmpty(cuentaRepository.findByNumeroCuenta(numeroCuenta))
                .filter(cuenta -> cuenta != null) // Aseguramos que la cuenta no es nula
                .switchIfEmpty(Mono.error(new CustomException(String.format(ErrorMessages.CUENTA_NO_ENCONTRADO, numeroCuenta)))); // Si la cuenta es nula, lanzamos un error

        return cuentaMono
                .map(cuenta -> {
                    BigDecimal montoDecimal = BigDecimal.valueOf(monto);

                    if (cuenta.getSaldoInicial().add(montoDecimal).compareTo(BigDecimal.ZERO) < 0) {
                        throw new CustomException("Saldo no disponible");
                    }
                    String typeMov = monto > 0 ? "DEPOSITO" : "RETIRO";
                    // Actualizar saldo
                    BigDecimal saldoCurrent = cuenta.getSaldoInicial();
                    cuenta.setSaldoInicial(cuenta.getSaldoInicial().add(montoDecimal));
                    // Guardar la cuenta actualizada
                    cuentaRepository.save(cuenta);

                    Movimiento movimiento = new Movimiento();
                    movimiento.setCuenta(cuenta);
                    movimiento.setValor(montoDecimal);
                    movimiento.setSaldo(saldoCurrent);
                    movimiento.setFecha(LocalDateTime.now());
                    movimiento.setTipoMovimiento(typeMov);
                    // Guardar el movimiento
                    movimientoRepository.save(movimiento);

                    return movimiento; // Devolver el objeto Movimiento
                })
                .onErrorResume(CustomException.class, ex -> Mono.error(new CustomException("Error al realizar el movimiento: " + ex.getMessage())));


    }

}
