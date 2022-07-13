package com.example.libraryapplication.controller;

import com.example.libraryapplication.entity.Book;
import com.example.libraryapplication.model.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookControllerAPI {
    @Autowired
    BookService bookService;
    //Create
    @PostMapping
    public ResponseEntity createBook(@RequestBody Book book){
        return ResponseEntity.ok(bookService.save(book));
    }
    /*

     */
    //Update
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book update){
        return bookService.update(id,update);
    }
    /*
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book update){
        if(bookService.findById(id).isEmpty()){
            System.out.println("Khong tim thay id");
            ResponseEntity.badRequest().build();
        }
        update.setId(id);
        //return ResponseEntity.ok(bookService.save(update));
        return ResponseEntity.ok(bookService.save(update));
    }
     */

    //View
    @GetMapping
    public List<Book> viewAllBook(){
        return bookService.findAllBook();
    }
    //Delete
    @DeleteMapping("/{id}")
    public void deleteBook(int id){
        bookService.deleteById(id);
    }
}
