package com.test.sofka.AccountMovements.service;

import com.test.sofka.AccountMovements.exception.CustomException;
import com.test.sofka.AccountMovements.model.entity.Cliente;
import com.test.sofka.AccountMovements.model.entity.Cuenta;
import com.test.sofka.AccountMovements.respository.ClienteRepository;
import com.test.sofka.AccountMovements.respository.CuentaRepository;
import com.test.sofka.AccountMovements.utils.ErrorMessages;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * Client Service
 *
 * @autor maicoly
 * @fecha 2025/02/16
 */
@Service
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    public Mono<Cuenta> createCuenta(Cuenta cuenta) {
        Optional<Cliente> cliente = clienteRepository.findByClienteId(cuenta.getCliente().getClienteId());
        if(!cliente.isPresent()){
            throw new CustomException(String.format(ErrorMessages.CLIENTE_NO_ENCONTRADO, cuenta.getCliente().getClienteId()));
        }
        cuenta.setCliente(cliente.get());
        return Mono.fromCallable(() -> cuentaRepository.save(cuenta))
                .onErrorResume(Throwable.class, e -> {
                    return Mono.error(new CustomException(ErrorMessages.OPERACION_ERROR, e.getMessage()));
                });
    }

    // Método para actualizar una cuenta
    public Mono<Cuenta> actualizarCuenta(String numeroCuenta, Cuenta cuenta) {
        return Mono.fromCallable(() -> cuentaRepository.findByNumeroCuenta(numeroCuenta))
                .flatMap(cuentaExistente -> {
                    if (cuentaExistente == null) {
                        return Mono.error(new CustomException(String.format(ErrorMessages.CUENTA_NO_ENCONTRADO, numeroCuenta)));
                    }
                    if (!"AHORROS".equals(cuenta.getTipoCuenta()) && !"CORRIENTE".equals(cuenta.getTipoCuenta())) {
                        return Mono.error(new CustomException(ErrorMessages.CUENTA_NO_VALIDA));
                    }
                    cuenta.setNumeroCuenta(numeroCuenta);
                    return Mono.fromCallable(() -> cuentaRepository.save(cuenta));
                })
                .onErrorResume(Throwable.class, e -> {
                    return Mono.error(new CustomException(ErrorMessages.CLIENTE_NO_SE_PUDO_ACTUALIZAR, e.getMessage()));
                });
    }



    // Método para encontrar la cuenta
    public Mono<Cuenta> findByNumeroCuenta(String numeroCuenta) {
        Optional<Cuenta> cuentaOptional = cuentaRepository.findByNumeroCuentaAndEstado(numeroCuenta, true);
        return Mono.justOrEmpty(cuentaOptional);
    }

    public Flux<Cuenta> getAllCuentas() {
        return Flux.fromIterable(cuentaRepository.findAll());
    }

    @Transactional
    public ResponseEntity<Void> deleteCliente(String numeroCuenta) {
            Optional<Cuenta> cuenta = cuentaRepository.findByNumeroCuenta(numeroCuenta);
            if(!cuenta.isPresent()){
                throw new CustomException(String.format(ErrorMessages.CUENTA_NO_ENCONTRADO, numeroCuenta));
            }
            cuentaRepository.delete(cuenta.get());
            return ResponseEntity.ok().build();
    }

}
