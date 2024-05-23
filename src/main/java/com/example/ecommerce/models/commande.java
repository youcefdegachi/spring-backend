package com.example.ecommerce.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Commande {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comId;

    private String numcom;
    private Date datecom;


    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public static Commande getCommandeById(Long id) {
        return getCommandeById(id);
    }

//    public static Commande getCommandeById(Long id) {
//    }

    public Commande save(Commande commande) {
        return commande;
    }
}