package com.example.project.repository;

import com.example.project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

   public List<Product> findByBrand(String brand);

   @Query("SELECT p from Product p WHERE " +
           "LOWER(p.name) LIKE LOWER(COUNT('% :keyword %'))")
   List<Product> searchProducts(String keyword);

}
