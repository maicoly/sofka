package com.test.sofka.ClientPerson.service;

import com.test.sofka.ClientPerson.exception.CustomException;
import com.test.sofka.ClientPerson.model.entity.Cliente;
import com.test.sofka.ClientPerson.respository.ClienteRepository;
import com.test.sofka.ClientPerson.utils.ErrorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Client Service
 *
 * @autor maicoly
 * @fecha 2025/02/16
 */
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    /**
     * service for create new clients.
     *
     * @param cliente ojject client that contains all data for create the client.
     * @return Mono<Cliente> A Mono response for async process.
     * resume: save a new client
     * @throws CustomException in case exist an exception.
     */
    public Mono<Cliente> createCliente(Cliente cliente) {
        return Mono.fromCallable(() -> clienteRepository.save(cliente))
                .onErrorResume(Throwable.class, e -> {
                    return Mono.error(new CustomException(ErrorMessages.OPERACION_ERROR, e.getMessage()));
                });
    }


    /**
     * service for update a specific client.
     *
     * @param id identified for a client.
     * @param cliente ojject client that contains all data for create the client.
     * @return Mono<Cliente> A Mono response for async process.
     * resume: if exist a client then the process for update continue
     * @throws CustomException in case exist an exception.
     */
    public Mono<Cliente> updateCliente(Long id, Cliente cliente) {
        return Mono.fromCallable(() -> {
                    if (!clienteRepository.existsById(id)) {
                        throw new CustomException(String.format(ErrorMessages.CLIENTE_NO_ENCONTRADO, id));
                    }
                    cliente.setId(id);
                    return clienteRepository.save(cliente);
                })
                .onErrorResume(Throwable.class, e -> {
                    return Mono.error(new CustomException(ErrorMessages.CLIENTE_NO_SE_PUDO_ACTUALIZAR, e.getMessage()));
                });
    }

    /**
     * service for delete a specific client.
     *
     * @param id identified for a client.
     * @return Mono<Cliente> A Mono response for async process.
     * resume: if exist a client then the process for delete continue
     * @throws CustomException in case exist an exception.
     */
    public Mono<Void> deleteCliente(Long id) {
        return Mono.defer(() -> Mono.just(id)  // Creamos un Mono con el id
                .flatMap(clienteId -> {
                    if (!clienteRepository.existsById(clienteId)) {
                        return Mono.error(new CustomException(String.format(ErrorMessages.CLIENTE_NO_ENCONTRADO, id)));
                    }
                    return Mono.fromRunnable(() -> clienteRepository.deleteById(id));
                })
                .onErrorResume(CustomException.class, ex -> {
                    return Mono.error(new CustomException(ErrorMessages.CLIENTE_CON_RESTRICCIONES_INTEGRIDAD, ex.getMessage()));
                })
        ).then();
    }


    /**
     * service for list all clients .
     *
     * @return Mono<Cliente> A Mono response for async process.
     * @throws CustomException in case exist an exception.
     */
    public Flux<Cliente> getAllClientes() {
        return Flux.fromIterable(clienteRepository.findAll());  // Retorna un Flux con todos los clientes
    }
}
