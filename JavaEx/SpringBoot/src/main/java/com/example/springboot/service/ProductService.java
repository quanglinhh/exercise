package com.example.springboot.service;

import com.example.springboot.entity.Product;
import com.example.springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public List<Product> getAllProduct(){
       return productRepository.findAll();
    }
    public Optional<Product> findById(long id){
        return productRepository.findById(id);
    }
    public Product create(Product product){
        return productRepository.save(product);
    }
    public void deleteById(long id){
        productRepository.deleteById(id);
    }
    //

}
