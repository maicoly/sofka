package com.test.sofka.AccountMovements.respository;

import com.test.sofka.AccountMovements.model.entity.Cliente;
import com.test.sofka.AccountMovements.model.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByClienteId(String clienteId);
}
