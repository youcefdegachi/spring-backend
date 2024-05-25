package com.example.ecommerce.services;

import com.example.ecommerce.execeptions.ProductNotFoundException;
import com.example.ecommerce.models.Product;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    
    public List<Product> getProduct(){
        return productRepository.findAll();
    }
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }


    public Product save(Product s) {
        return productRepository.saveAndFlush(s);
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    public void delete(Long s) {
        productRepository.delete(s);
    }
}
