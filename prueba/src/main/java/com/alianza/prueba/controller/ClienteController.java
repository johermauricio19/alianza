package com.alianza.prueba.controller;

import com.alianza.prueba.model.Cliente;
import com.alianza.prueba.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> getClientes(@RequestParam(required = false) String sharedKey) {
        if (sharedKey != null) {
            return clienteRepository.findBySharedKeyContaining(sharedKey);
        }
        return clienteRepository.findAll();
    }

    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
