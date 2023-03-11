package com.book.service;

import com.book.model.Book;
import com.book.model.BookInput;

import java.util.List;

public interface BookService {
    Book create(Book book);

    List<Book> getAll();

    Book get(int bookId);

    Book update(int bookId, BookInput books);

    Void delete(int bookId);

}
