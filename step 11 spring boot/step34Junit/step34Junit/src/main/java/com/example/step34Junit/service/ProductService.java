package com.example.step34Junit.service;

import com.example.step34Junit.entiry.Product;
import com.example.step34Junit.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(()->
                        new RuntimeException("Product not found"));
    }

    public Product createProduct(Product product) {
        boolean alreadyExists = productRepository.existsByName(product.getName());
        if(alreadyExists){
            throw new IllegalArgumentException("Product already exists");
        }
        return productRepository.save(product);
    }
}
