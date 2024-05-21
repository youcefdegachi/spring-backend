package com.example.ecommerce.repository;

import com.example.ecommerce.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository  extends JpaRepository<Client,Long> {
}
