package com.example.project.service;

import com.example.project.model.Product;
import com.example.project.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
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

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
       product.setImageName(imageFile.getOriginalFilename());
       product.setImageType(imageFile.getContentType());
       product.setImageData(imageFile.getBytes());
       return productRepository.save(product);
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
       product.setImageData(imageFile.getBytes());
       product.setImageName(imageFile.getOriginalFilename());
       product.setImageType(imageFile.getContentType());
      return productRepository.save(product);
    }

    public void deleteProduct(int id) {
      productRepository.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
       return productRepository.searchProducts(keyword);
    }
}
