package com.example.ecommerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clId;

    private String numcl;
    private String nomcl;
    private String prenomcl;
    private String adressecl;
    private String telcl;

    private String email;
    private String password;


    public Client save(Client client) {
        return client;
    }

//    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
//    private Set<Commande> commandes;
}
