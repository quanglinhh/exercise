package com.example.libraryapplication.model;

import com.example.libraryapplication.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class BookService {
    private final List<Book> books = new ArrayList<>();
    //DI: Dependency Injection
    //Cách 1

    @Autowired//Annotation
    BookRepository bookRepository;
     //Cách2
    //private final BookRepository bookRepository;

    public Book save(Book book){
        return bookRepository.save(book);
    }
    public List<Book> findAllBook(){
      return bookRepository.findAll();
    }


    public void deleteById(int id){
        bookRepository.deleteById(id);
    }
    public Optional<Book> findById(int id){
        return bookRepository.findById(id);
    }
    public Book update(int id , Book newBook){
        if(bookRepository.findById(id).isPresent()){
            Optional<Book> book1 = findById(id);
            book1.stream().map(book -> {book.setTitle(newBook.getTitle());
                                        book.setDescription(newBook.getDescription());
                                        return book;})
                          .findFirst();
        }
        return bookRepository.save(newBook);
    }

}
