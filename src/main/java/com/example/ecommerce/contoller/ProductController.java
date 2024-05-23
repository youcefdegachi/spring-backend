package com.example.ecommerce.contoller;

import com.example.ecommerce.execeptions.NoClientExistInRepository;
import com.example.ecommerce.models.Commande;

import com.example.ecommerce.models.Product;
import com.example.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/product")
public class ProductController {
    @Autowired
    private ProductService product;

    @GetMapping
    public List<Product> getAllCommandes() {
        return product.getProduct();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.ok().body(product.getProduct());
        }catch (NoClientExistInRepository e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("List Not Found");
        }
    }

    @PostMapping("/add")
    public Product createProduct(@RequestBody Product product) {
        return product.save(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        product.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
