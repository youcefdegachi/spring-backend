package com.example.ecommerce.services;

import com.example.ecommerce.execeptions.CommandeNotFoundException;
import com.example.ecommerce.models.Commande;
import com.example.ecommerce.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commande;

    public List<Commande> getAllCommandes() {
        return commande.findAll();
    }
    public List<Commande> getCommande(){
        return commande.findAll();
    }

    public Commande getCommandeById(Long id) {
        return commande.findById(id).orElse(null);
    }
    public Commande save(Commande s) {
        return commande.saveAndFlush(s);
    }

//    public Commande findById(Long id) {
//        return commande.findById(id)
//                .orElseThrow(() -> new CommandeNotFoundException("commande not found with id: " + id));
//    }

    public void delete(Long s) {
        commande.delete(Commande.getCommandeById(s));
    }
}
