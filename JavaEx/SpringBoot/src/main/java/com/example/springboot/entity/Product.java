package com.example.springboot.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.DateTimeException;
import java.util.Date;

@Entity//Enotation
public class Product {
    @Id
    private long id;
    private String name;
    private String description;
    private BigDecimal price;
    @CreationTimestamp
    private Date createAt;
    @CreationTimestamp
    private Date updateAt;
}
