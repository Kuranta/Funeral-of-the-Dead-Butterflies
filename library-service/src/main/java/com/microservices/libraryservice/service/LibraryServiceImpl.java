package com.microservices.libraryservice.service;

import com.microservices.libraryservice.model.Book;
import com.microservices.libraryservice.model.Poetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService{

    private final WebClient webClient;

    @Autowired
    public LibraryServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public List<Poetry> getPoetryByTitle(String title) {
        List<Poetry> searchingPoetry = webClient.get()
                .uri("http://localhost:8999/api/v3/getPoetry/"+title)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(List.class)
                .block();
        return searchingPoetry;
    }

    @Override
    public List<Poetry> getPoetriesByAuthor(String author) {
        List<Poetry> searchingPoetries = webClient.get()
                .uri("http://localhost:8999/api/v3/getPoetries/"+author)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(List.class)
                .block();
        return searchingPoetries;
    }

    @Override
    public Book getBookByTitle(String title) {
        Book searchingBook = webClient.get()
                .uri("http://localhost:8888/api/v2/bookByTitle/"+title)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Book.class)
                .block();
        return searchingBook;
    }

    @Override
    public List<Book> getAllBooks() {
        return webClient.get()
                .uri("http://localhost:8888/api/v2/books")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(List.class)
                .block();
    }

    @Override
    public List<String> getBooksBySubject(String subject) {
        return webClient.get()
                .uri("http://localhost:8888/api/v2/booksBySubject/"+subject)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(List.class)
                .block();
    }
}
