package com.alianza.prueba;

import com.alianza.prueba.model.Cliente;
import com.alianza.prueba.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class PruebaApplication implements CommandLineRunner {

	@Autowired
	private ClienteService clienteService;

	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Crear 3 clientes iniciales
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		clienteService.saveCliente(new Cliente(
				"Juan Pérez", "1234567890", "juan.perez@correo.com",
				sdf.parse("2023-01-01"), sdf.parse("2025-01-01")
		));

		clienteService.saveCliente(new Cliente(
				"Ana López", "0987654321", "ana.lopez@correo.com",
				sdf.parse("2022-02-01"), sdf.parse("2025-02-01")
		));

		clienteService.saveCliente(new Cliente(
				"Carlos García", "1122334455", "carlos.garcia@correo.com",
				sdf.parse("2024-03-01"), sdf.parse("2025-03-01")
		));
	}
}
