package com.alianza.prueba.controller;

import com.alianza.prueba.model.Cliente;
import com.alianza.prueba.repository.ClienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteRepository clienteRepository;

    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        cliente = new Cliente();
        cliente.setSharedKey("key123");
        cliente.setBusinessId("business1");
        cliente.setEmail("cliente1@example.com");
        cliente.setPhone("123456789");
        cliente.setDateAdded(new java.util.Date());
    }

    @Test
    public void testGetClientes() throws Exception {
        when(clienteRepository.findBySharedKeyContaining("key123")).thenReturn(List.of(cliente));

        mockMvc.perform(get("/api/clientes?sharedKey=key123"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].sharedKey").value("key123"))
                .andExpect(jsonPath("$[0].businessId").value("business1"));
    }

    @Test
    public void testCreateCliente() throws Exception {
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        mockMvc.perform(post("/api/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(cliente)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sharedKey").value("key123"))
                .andExpect(jsonPath("$.businessId").value("business1"));
    }
}
