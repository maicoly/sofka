package com.test.sofka.ClientPerson.respository;

import com.test.sofka.ClientPerson.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
