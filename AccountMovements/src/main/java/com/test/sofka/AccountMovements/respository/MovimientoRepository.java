package com.test.sofka.AccountMovements.respository;

import com.test.sofka.AccountMovements.model.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {

}
