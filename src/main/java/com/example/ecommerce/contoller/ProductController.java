package com.example.ecommerce.contoller;

import com.example.ecommerce.execeptions.NoClientExistInRepository;
import com.example.ecommerce.execeptions.NoProductExistInRepository;
import com.example.ecommerce.models.Commande;

import com.example.ecommerce.models.Product;
import com.example.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/check")
    public String check(){
        return "Working...!";
    }
//    @GetMapping("/all")
//    public List<Product> getAllProduct() {
//        return productService.getProduct();
//    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProduct(){
        try{
            return new ResponseEntity<List<Product>>(productService.getProduct(), HttpStatus.OK);
        }catch (NoProductExistInRepository e){
            return new ResponseEntity("List Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.ok().body(productService.getProduct());
        }catch (NoClientExistInRepository e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product Not Found");
        }
    }

//    @PostMapping("/add")
//    public Product createProduct(@RequestBody Product product) {
//        return product.save(product);
//    }
    @PostMapping("/add")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) throws IOException {
        Product savedProduct = productService.save(product);
        return new ResponseEntity<Product>(savedProduct,HttpStatus.OK);
//        return new  ResponseEntity<Product>(savedProduct,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.delete( productService.findById(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get/by/id/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id){
        try {
//            return new ResponseEntity<Product>(productService.getById(id), HttpStatus.OK);
            return new ResponseEntity<Product>(productService.findById(id), HttpStatus.OK);
        }catch (NoProductExistInRepository e) {
            return new ResponseEntity("Product not found", HttpStatus.NOT_FOUND);
        }
    }
}
