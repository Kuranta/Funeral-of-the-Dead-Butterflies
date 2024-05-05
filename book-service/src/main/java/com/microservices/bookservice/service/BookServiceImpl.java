package com.microservices.bookservice.service;

import com.microservices.bookservice.model.Book;
import com.microservices.bookservice.model.Docs;
import com.microservices.bookservice.model.Subject;
import com.microservices.bookservice.model.Works;
import com.microservices.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final WebClient webClient;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, WebClient webClient) {
        this.bookRepository = bookRepository;
        this.webClient = webClient;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book findCertainBookByTitle(String title) {
        List<Book> allBooks = bookRepository.findAll();
        for (Book b : allBooks){
            List<Docs> docs = b.getDocs();
            for (Docs d : docs){
                if (d.getTitle().equals(title)){
                    return b;

                }
            }
        }
        Book searchingBook = webClient.get()
                .uri("https://openlibrary.org/search.json?q="+title)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Book.class)
                .block();

        Docs docs = searchingBook.getDocs().get(0);
        searchingBook.setDocs(List.of(docs));

        bookRepository.save(searchingBook);
        return searchingBook;
    }

    @Override
    public List<String> getBySubject(String subject) {
        Subject lookingSubject =  webClient.get()
                .uri("http://openlibrary.org/subjects/"+subject.toLowerCase()+".json?details=true")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Subject.class)
                .block();

        List<Works> list = lookingSubject.getWorks();
        List<String> titles = new ArrayList<>();
        for (Works w : list){
            titles.add(w.getTitle());
        }
        return titles;

    }

}
