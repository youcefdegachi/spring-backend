package com.example.ecommerce.contoller;


import com.example.ecommerce.models.Commande;
import com.example.ecommerce.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/commande")
public class CommandeController {
    @Autowired
    private CommandeService commande;

    @GetMapping
    public List<Commande> getAllCommandes() {
        return commande.getAllCommandes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommandeById(@PathVariable Long id) {
        Commande commande = Commande.getCommandeById(id);
        if (commande != null) {
            return new ResponseEntity<>(commande, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public Commande createCommande(@RequestBody Commande commande) {
        return commande.save(commande);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommande(@PathVariable Long id) {
        commande.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
