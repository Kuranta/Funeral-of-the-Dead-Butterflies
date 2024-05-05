package com.microservices.libraryservice.service;

import com.microservices.libraryservice.model.Book;
import com.microservices.libraryservice.model.Poetry;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public interface LibraryService {
    public List<Poetry> getPoetryByTitle(String title);
    public List<Poetry> getPoetriesByAuthor(String author);
    public Book getBookByTitle(String title);
    public List<Book> getAllBooks();
    public List<String> getBooksBySubject(String subject);
}
