package com.example.myspringbootproject;

import com.example.myspringbootproject.entity.Book;
import com.example.myspringbootproject.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public Book createBook(Book book){
        return bookRepository.save(book);
    }
}
