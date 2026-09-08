package com.example.step34Junit.controller;

import com.example.step34Junit.entiry.Product;
import com.example.step34Junit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

  public ProductService productService;

  @Autowired
  public ProductController(ProductService productService){
      this.productService = productService;
  }

  @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id){
      Product product = productService.getProductById(id);
      return ResponseEntity.ok(product);
  }

  @PostMapping()
  public ResponseEntity<Product> createProduct(@RequestBody Product product){
      Product savedProduct = productService.createProduct(product);
      return ResponseEntity.ok(savedProduct);
  }

}
