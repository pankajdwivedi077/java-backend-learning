package com.example.step34Junit.repository;

import com.example.step34Junit.entiry.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    boolean existsByName(String name);
}
