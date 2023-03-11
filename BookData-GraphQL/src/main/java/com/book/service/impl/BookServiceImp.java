package com.book.service.impl;

import com.book.model.Book;
import com.book.model.BookInput;
import com.book.repository.BookRepository;
import com.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImp implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImp(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book create(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    public List<Book> getAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book get(int bookId) {
        return this.bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book you are looking for not found"));
    }

    @Override
    public Book update(int bookId, BookInput books) {
        return this.bookRepository.findById(bookId).map(book -> {
            System.out.println(book.getId() + "service");
            book.setAuthor(books.getAuthor());
            book.setDesc(books.getDesc());
            book.setTitle(books.getTitle());
            book.setPages(books.getPages());
            book.setPrice(books.getPrice());
            return bookRepository.save(book);
        }).orElseThrow(() -> new RuntimeException("Enter Book details correctly"));
    }

    @Override
    public Void delete(int bookId) {
        this.bookRepository.deleteById(bookId);
        return null;
    }
}
