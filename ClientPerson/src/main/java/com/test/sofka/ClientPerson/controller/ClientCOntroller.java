package com.test.sofka.ClientPerson.controller;

import com.test.sofka.ClientPerson.exception.CustomException;
import com.test.sofka.ClientPerson.model.entity.Cliente;
import com.test.sofka.ClientPerson.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Main controller for CRUD clients request
 *
 * @autor maicoly
 * @fecha 2025/02/16
 */
@RestController
@RequestMapping("clientes")
public class ClientCOntroller {

    @Autowired
    private ClienteService clienteService;

    /**
     * service for create new clients.
     *
     * @param cliente ojject client that contains all data for create the client.
     * @return Mono<Cliente> A Mono response for async process.
     * @throws CustomException in case exist an exception.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Cliente> createCliente(@RequestBody Cliente cliente) {
        return clienteService.createCliente(cliente);
    }

    /**
     * service for update a specific client.
     *
     * @param id identified for a client.
     * @param cliente ojject client that contains all data for create the client.
     * @return Mono<Cliente> A Mono response for async process.
     * @throws CustomException in case exist an exception.
     */
    @PutMapping("/{id}")
    public Mono<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.updateCliente(id, cliente);
    }

    /**
     * service for delete a specific client.
     *
     * @param id identified for a client.
     * @return Mono<Cliente> A Mono response for async process.
     * @throws CustomException in case exist an exception.
     */
    @DeleteMapping("/{id}")
    public Mono<Void> deleteCliente(@PathVariable Long id) {
        return clienteService.deleteCliente(id);
    }

    /**
     * service that list all clients
     *
     * @return Mono<Cliente> A Mono response for async process.
     * @throws CustomException in case exist an exception.
     */
    @GetMapping
    public Flux<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

}
