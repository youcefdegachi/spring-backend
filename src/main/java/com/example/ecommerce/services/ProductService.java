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
    private ProductRepository product;
    public List<Product> getProduct(){
        return product.findAll();
    }

    public Product save(Product s) {
        return product.saveAndFlush(s);
    }

    public Product findById(Long id) {
        return product.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    public void delete(Product s) {
        product.delete(s);
    }
}
