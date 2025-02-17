package com.test.sofka.ClientPerson;

import com.test.sofka.ClientPerson.controller.ClientCOntroller;
import com.test.sofka.ClientPerson.model.entity.Cliente;
import com.test.sofka.ClientPerson.model.enums.Genero;
import com.test.sofka.ClientPerson.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(MockitoExtension.class)
class ClientPersonApplicationTests {


	@Autowired
	private WebTestClient webTestClient;
	@Mock
	private ClienteService clienteService;
	@InjectMocks  // Inyecta el mock del servicio en el controlador
	private ClientCOntroller clientController;
	@Test
	void createCliente() {
		Cliente cliente = new Cliente();
		cliente.setNombre("Eli");
		cliente.setClienteId("66");
		cliente.setGenero(Genero.MASCULINO);
		cliente.setContrasena("bittersweet123..");
		cliente.setIdentificacion("030118724");
		cliente.setEstado(true);
		Mockito.lenient().when(clienteService.createCliente(cliente)).thenReturn(Mono.just(cliente));
		webTestClient.post()
				.uri("/clientes")
				.bodyValue(cliente)
				.exchange()
				.expectStatus().isCreated()
				.expectBody()
				.consumeWith(response -> {
					String responseBody = new String(response.getResponseBody());
					System.out.println(responseBody);  // Imprime el cuerpo de la respuesta para ver el error
				});
	}

}
