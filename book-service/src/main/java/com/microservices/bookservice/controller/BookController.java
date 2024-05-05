package com.microservices.bookservice.controller;

import com.microservices.bookservice.model.Book;
import com.microservices.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v2")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/booksBySubject/{subject}")
    public List<String> getBooksBySubject(@PathVariable String subject){
        return bookService.getBySubject(subject);
    }

    @GetMapping("/bookByTitle/{title}")
    public Book getBookByTitle(@PathVariable String title){
        Book book = bookService.findCertainBookByTitle(title);
        return book;
    }


}
