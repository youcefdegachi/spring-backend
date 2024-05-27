package com.example.ecommerce.repository;

import com.example.ecommerce.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository  extends JpaRepository<Client,Long> {
    Optional<Client> findByEmailAndPassword(String email, String password);
//    Client save(Client product);
}
