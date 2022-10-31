package com.mongo.controller;

import com.mongo.model.Book;
import com.mongo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/add")
    public String addBook(@RequestBody Book book){
        bookRepository.save(book);
        return "Added Book with id :" + book.getId();
    }

    @GetMapping("/all")
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/all/{id}")
    public Optional<Book> getOneBook(@PathVariable int id){
        return bookRepository.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id){
         bookRepository.deleteById(id);
         return "Book deleted with id:" + id;
    }
}
