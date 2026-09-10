package com.example.project.service;

import com.example.project.model.Product;
import com.example.project.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

   private ProductRepository productRepository;

   public ProductService(ProductRepository productRepository){
       this.productRepository = productRepository;
   }

    public List<Product> getAllProducts() {
         return productRepository.findAll();
    }


    public Product getProductById(int id) {
       return productRepository.findById(id).orElseThrow(()->
               new RuntimeException("product not found"));
    }
}
