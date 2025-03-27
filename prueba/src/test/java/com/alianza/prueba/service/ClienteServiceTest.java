package com.alianza.prueba.service;

import com.alianza.prueba.model.Cliente;
import com.alianza.prueba.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        cliente = new Cliente("Juan Pérez", "1234567890", "juan.perez@correo.com", null, null);
    }

    @Test
    public void testSaveCliente() {
        // Arrange
        when(clienteRepository.save(cliente)).thenReturn(cliente);

        // Act
        Cliente savedCliente = clienteService.saveCliente(cliente);

        // Assert
        assertNotNull(savedCliente);
        assertEquals(cliente.getNombre(), savedCliente.getNombre());
        verify(clienteRepository, times(1)).save(cliente); // Verificamos que el método save fue llamado
    }

    @Test
    public void testGetAllClientes() {
        // Arrange
        List<Cliente> clientes = Arrays.asList(cliente);
        when(clienteRepository.findAll()).thenReturn(clientes);

        // Act
        List<Cliente> clienteList = clienteService.getAllClientes();

        // Assert
        assertEquals(1, clienteList.size());
        assertEquals(cliente.getNombre(), clienteList.get(0).getNombre());
        verify(clienteRepository, times(1)).findAll();
    }

    @Test
    public void testSearchClientes() {
        // Arrange
        String sharedKey = "JP";
        List<Cliente> clientes = Arrays.asList(cliente);
        when(clienteRepository.findBySharedKeyContaining(sharedKey)).thenReturn(clientes);

        // Act
        List<Cliente> clienteList = clienteService.searchClientes(sharedKey);

        // Assert
        assertEquals(1, clienteList.size());
        assertEquals(cliente.getNombre(), clienteList.get(0).getNombre());
        verify(clienteRepository, times(1)).findBySharedKeyContaining(sharedKey);
    }
}
