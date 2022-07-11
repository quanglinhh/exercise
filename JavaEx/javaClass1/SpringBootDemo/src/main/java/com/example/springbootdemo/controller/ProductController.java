package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.Product;
import com.example.springbootdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/v1/Products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("")
    List<Product> getAllProducts(){
        return productRepository.findAll();
    }

}
