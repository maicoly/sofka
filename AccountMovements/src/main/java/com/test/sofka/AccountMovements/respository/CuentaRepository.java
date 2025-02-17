package com.test.sofka.AccountMovements.respository;

import com.test.sofka.AccountMovements.model.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
//    Mono<Cuenta> findByNumeroCuenta(String numeroCuenta);
    Optional<Cuenta> findByNumeroCuenta(String numeroCuenta);
    Optional<Cuenta> findByNumeroCuentaAndEstado(String numeroCuenta, Boolean estado);
    void deleteByNumeroCuenta(String numeroCuenta);


}
