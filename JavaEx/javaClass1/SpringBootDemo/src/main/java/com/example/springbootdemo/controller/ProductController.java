package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.Product;
import com.example.springbootdemo.entity.ResponseObject;
import com.example.springbootdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/v1/Products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("")
    List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id){
        Optional<Product> foundProduct  = productRepository.findById(id);
        return foundProduct.isPresent()?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok","Query product succesfully",foundProduct))
                        :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("false","Product not found by id ="+id,""));
    }
    //Postman: Raw, JSON
    @PostMapping("/insert")
   ResponseEntity<ResponseObject> insertProduct(@RequestBody Product newProduct){
        //2 product must not have the same name
        List<Product> foundProducts = productRepository.findByProductName(newProduct.getProductName().trim());
        if(foundProducts.size() > 0){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed","Product name already taken","")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","Insert product succesfully",productRepository.save(newProduct))
        );
   }
    //Update, insert = update if found, otherwisr insert
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateProduct(@RequestBody Product newProduct,@PathVariable Long id){
        Product updateProduct = productRepository.findById(id)
                .map(product -> {
                    product.setProductName(newProduct.getProductName());
                    product.setYear(newProduct.getYear());
                    product.setPrice(newProduct.getPrice());
                    return productRepository.save(product);
                }).orElseGet(()->{
                    newProduct.setId(id);
                    return productRepository.save(newProduct);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","Update Product Successfully",updateProduct)
        );
    }
    //Delete Product
    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteProduct(@PathVariable Long id){
        boolean exist = productRepository.existsById(id);
        if(exist){
            productRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok","Delete product successfully","")
            );
        }return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("Failed","Cannot find product to delete","")
        );

    }
}
