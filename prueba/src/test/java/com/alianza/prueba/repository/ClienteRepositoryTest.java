package com.alianza.prueba.repository;

import com.alianza.prueba.model.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
public class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    private Cliente cliente1;
    private Cliente cliente2;

    @BeforeEach
    public void setUp() {
        clienteRepository.deleteAll();  // Limpiar antes de cada prueba

        cliente1 = new Cliente();
        cliente1.setSharedKey("key123");
        cliente1.setBusinessId("business1");
        cliente1.setEmail("cliente1@example.com");
        cliente1.setPhone("123456789");
        cliente1.setDateAdded(new java.util.Date());

        cliente2 = new Cliente();
        cliente2.setSharedKey("key456");
        cliente2.setBusinessId("business2");
        cliente2.setEmail("cliente2@example.com");
        cliente2.setPhone("987654321");
        cliente2.setDateAdded(new java.util.Date());

        clienteRepository.save(cliente1);
        clienteRepository.save(cliente2);
    }

    @Test
    public void testFindBySharedKeyContaining() {
        List<Cliente> clientes = clienteRepository.findBySharedKeyContaining("key123");
        assertEquals(1, clientes.size());
        assertEquals("key123", clientes.get(0).getSharedKey());
    }

    @Test
    public void testFindAllClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        assertEquals(2, clientes.size());
    }
}

