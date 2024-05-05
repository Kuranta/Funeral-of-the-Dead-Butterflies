package com.microservices.libraryservice.controller;

import com.microservices.libraryservice.model.Book;
import com.microservices.libraryservice.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    private final LibraryService libraryService;

    @Autowired
    public BookController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/book/{title}")
    public Book getBookByTitle(@PathVariable String title){
        return libraryService.getBookByTitle(title);
    }

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return libraryService.getAllBooks();
    }

    @GetMapping("books/{subject}")
    public List<String> getBooksBySubject(@PathVariable String subject){
        return libraryService.getBooksBySubject(subject);
    }
}
