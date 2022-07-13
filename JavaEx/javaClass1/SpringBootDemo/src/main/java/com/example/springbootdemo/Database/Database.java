package com.example.springbootdemo.Database;

import com.example.springbootdemo.entity.Product;
import com.example.springbootdemo.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {

    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase(ProductRepository repository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Product productA = new Product("Product1",2020,2400.0,"");
                Product productB = new Product("Product2",2022,599.0,"");
                logger.info("insert data: "+repository.save(productA));
                logger.info("insert data: "+repository.save(productB));
            }
        };

    }


}
