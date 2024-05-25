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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long artId;
    private String pname;
    private String desart;
    private String couleur;
    private Double puart;
    private Integer qtestock;
//    private String image;


    public Product save(Product product) {
        return product;
    }
}
