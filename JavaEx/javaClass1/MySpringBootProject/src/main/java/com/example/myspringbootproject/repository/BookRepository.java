package com.example.myspringbootproject.repository;

import com.example.myspringbootproject.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BookRepository extends JpaRepository<Book, Integer> {
}
