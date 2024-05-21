package com.example.ecommerce.services;

import com.example.ecommerce.execeptions.ClientNotFoundException;
import com.example.ecommerce.execeptions.CommandeNotFoundException;
import com.example.ecommerce.models.Client;
import com.example.ecommerce.models.Commande;
import com.example.ecommerce.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ClientService {
    @Autowired
    private ClientRepository client;
    public List<Client> getClient(){
        return client.findAll();
    }

    public Client save(Client s) {
        return client.saveAndFlush(s);
    }

    public Client findById(Long id) {
        return client.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("client not found with id: " + id));
    }

    public void delete(Client s) {
        client.delete(s);
    }
}
