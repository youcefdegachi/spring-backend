package com.example.ecommerce.services;

import com.example.ecommerce.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ClientService {
    @Autowired
    private ClientRepository client;
}
