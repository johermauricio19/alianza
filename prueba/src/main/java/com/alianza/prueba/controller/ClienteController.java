package com.alianza.prueba.controller;

import com.alianza.prueba.model.Cliente;
import com.alianza.prueba.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/crear")
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteService.saveCliente(cliente);
    }

    @GetMapping("/")
    public List<Cliente> getClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/search")
    public List<Cliente> searchClientes(@RequestParam String sharedKey) {
        return clienteService.searchClientes(sharedKey);
    }
}


