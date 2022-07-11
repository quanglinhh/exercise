package com.example.springbootdemo.repository;

import com.example.springbootdemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
