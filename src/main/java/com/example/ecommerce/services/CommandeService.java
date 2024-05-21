package com.example.ecommerce.services;

import com.example.ecommerce.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commande;
}
