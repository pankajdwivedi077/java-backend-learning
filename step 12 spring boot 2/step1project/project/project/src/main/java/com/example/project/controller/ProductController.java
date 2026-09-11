package com.example.project.controller;

import com.example.project.model.Product;
import com.example.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProduct(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id){
        Product product = productService.getProductById(id);
        if(product != null)
            return new ResponseEntity<>(product, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/products")
    public ResponseEntity<?> addProduct(@RequestPart Product product,
                                        @RequestPart MultipartFile imageFile){
     try{
         Product product1 = productService.addProduct(product, imageFile);
         return new ResponseEntity<>(product1, HttpStatus.CREATED);
     }catch(Exception e){
         return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
     }

    }

    @GetMapping("/products/{id}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int id){
        Product product = productService.getProductById(id);
        byte[] imageFile = product.getImageData();
        return ResponseEntity.ok().contentType
                (MediaType.valueOf(product.getImageType())).body(imageFile);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id ,@RequestPart Product product,
                                                @RequestPart MultipartFile imageFile){
        Product product1 = null;
        try {
            product1 = productService.updateProduct(id, product, imageFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(product1 != null){
           return new ResponseEntity<>("updated", HttpStatus.OK);
       }else{
           return new ResponseEntity<>("failed to updated", HttpStatus.BAD_REQUEST);
       }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        Product product = productService.getProductById(id);
        if(product != null){
            productService.deleteProduct(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProduct(@RequestParam String keyword){
        List<Product> products = productService.searchProducts(keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
