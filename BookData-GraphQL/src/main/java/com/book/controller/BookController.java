package com.book.controller;

import com.book.model.Book;
import com.book.model.BookInput;
import com.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @MutationMapping("createBook")
    public Book create(@Argument Book book) {
        Book b = new Book();
        b.setTitle(book.getTitle());
        b.setDesc(book.getDesc());
        b.setPrice(book.getPrice());
        b.setAuthor(book.getAuthor());
        b.setPages(book.getPages());
        return this.bookService.create(b);
    }

    @QueryMapping("allBooks")
    public List<Book> getAll() {
        return this.bookService.getAll();
    }

    @QueryMapping("getBook")
    public Book get(@Argument int bookId) {
        return this.bookService.get(bookId);
    }

    @MutationMapping("updateBook")
    public Book updateBook(@Argument int bookId, @Argument BookInput book) {
        System.out.println(bookId + "controller");
        return this.bookService.update(bookId, book);
    }

    @MutationMapping("deleteBook")
    public String delete(@Argument int bookId) {
        this.bookService.delete(bookId);
        return "Book deleted with id: " + bookId;
    }

}
