package com.test.sofka.AccountMovements.respository;

import com.test.sofka.AccountMovements.model.entity.Cuenta;
import com.test.sofka.AccountMovements.model.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    List<Movimiento> findByCuentaAndFechaBetween(Cuenta cuenta, LocalDateTime fechaInicio, LocalDateTime fechaFin);

}
