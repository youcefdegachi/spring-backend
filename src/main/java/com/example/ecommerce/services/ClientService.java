package com.example.ecommerce.services;

import com.example.ecommerce.execeptions.ClientNotFoundException;
import com.example.ecommerce.models.Client;
import com.example.ecommerce.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

//    public List<Client> getClient(){
//        return client.findAll();
//    }

    public Client save(Client s) {
        return clientRepository.saveAndFlush(s);
    }

    public  Client findById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("client not found with id: " + id));
    }
//    @Override
//    public Client add1(Client client) {
//        return ClientRepository.save(client);
//    }

    public void delete(Client s) {
        clientRepository.delete(s);
    }

    public Optional<Client> login(String email, String password) {
        return clientRepository.findByEmailAndPassword(email, password);
    }
}
