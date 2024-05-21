package com.example.ecommerce.repository;

import com.example.ecommerce.models.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandRepository  extends JpaRepository<Commande,Long> {
}
