package com.microservices.bookservice.service;

import com.microservices.bookservice.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookService {

    public List<Book> getAllBooks();
    public Book saveBook(Book book);
    public Book findCertainBookByTitle(String title);
    public List<String> getBySubject(String subject);

}

