package com.example.step34Junit.service;

import com.example.step34Junit.entiry.Product;
import com.example.step34Junit.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void shouldReturnProductWhenProductExist(){
        //Arrange
        Product product = new Product("Laptop",5000,10);

        when(productRepository.findById(1L))
                .thenReturn(Optional.of(product));

        //Act
        Product actualResult = productService.getProductById(1L);

        // Assert
//        assertEquals(1L, actualResult.getId());
        assertEquals("Laptop", actualResult.getName());

        verify(productRepository).findById(1L);
    }

    @Test
    void shouldThrowExceptionWhenProudctDoesNotExist(){
        //Arrange
        when(productRepository.findById(99L))
                .thenReturn(Optional.empty());
        //Act
        RuntimeException exception = assertThrows(RuntimeException.class, ()->
                productService.getProductById(99L));
        //Assertion
        assertEquals("Product not found", exception.getMessage());

        verify(productRepository).findById(99L);
    }
    @Test
    void shouldCreateProductWhenNameIsUnique(){
        //Arrange
        Product request = new Product("Keyboard", 200, 5);
        Product savedProduct = new Product("Keyboard", 200, 5);
        when(productRepository.existsByName("Keyboard"))
                .thenReturn(false);
        when(productRepository.save(request))
                .thenReturn(savedProduct);

        //Act
        Product result = productService.createProduct(request);

        //Assert
        assertEquals("Keyboard",result.getName());

        verify(productRepository);

        verify(productRepository)
                .save(request);
    }
}
