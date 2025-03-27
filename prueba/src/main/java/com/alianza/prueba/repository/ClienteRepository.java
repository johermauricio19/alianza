package com.alianza.prueba.repository;

import com.alianza.prueba.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findBySharedKeyContaining(String sharedKey);
}

