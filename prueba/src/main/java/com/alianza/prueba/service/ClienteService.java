package com.alianza.prueba.service;

import com.alianza.prueba.model.Cliente;
import com.alianza.prueba.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public List<Cliente> searchClientes(String sharedKey) {
        return clienteRepository.findBySharedKeyContaining(sharedKey);
    }
}
