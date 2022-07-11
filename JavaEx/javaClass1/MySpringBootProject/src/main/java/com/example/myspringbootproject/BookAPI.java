package com.example.myspringbootproject;

import com.example.myspringbootproject.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookAPI {
    @Autowired
    BookService bookService;
    @PostMapping
    public ResponseEntity create(@RequestBody Book book){
        return ResponseEntity.ok(bookService.createBook(book));
    }

}


