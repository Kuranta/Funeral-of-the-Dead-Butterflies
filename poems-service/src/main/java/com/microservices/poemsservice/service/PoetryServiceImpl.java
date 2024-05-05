package com.microservices.poemsservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.poemsservice.model.Poetry;
import com.microservices.poemsservice.repository.PoetryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.awt.print.Book;
import java.util.List;

@Service
public class PoetryServiceImpl implements PoetryService{

    private final PoetryRepository poetryRepository;
    private final WebClient webClient;

    @Autowired
    public PoetryServiceImpl(WebClient webClient, PoetryRepository poetryRepository) {
        this.webClient = webClient;
        this.poetryRepository = poetryRepository;
    }

    @Override
    public List<Poetry> getAllPoetries() {
        return poetryRepository.findAll();
    }

    @Override
    public Poetry savePoetry(Poetry poetry) {
        return poetryRepository.save(poetry);
    }

    @Override
    public List<Poetry> findPoetryByTitle(String title) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Poetry> allPoetries = poetryRepository.findAll();
        for (Poetry p : allPoetries){
            if (p.getTitle().equals(title)){
                return List.of(p);
            }
        }

        List<Poetry> searchingPoetry = webClient.get()
                .uri("https://poetrydb.org/title/"+title)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(List.class)
                .block();

        poetryRepository.saveAll(objectMapper.convertValue(searchingPoetry,new TypeReference<List<Poetry>>(){}));
        return searchingPoetry;
    }

    @Override
    public List<Poetry> findPoetriesByAuthor(String author){
        List<Poetry> searchingPoetry = webClient.get()
                .uri("https://poetrydb.org/author/"+author.toLowerCase())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(List.class)
                .block();
        return searchingPoetry;
    }
}
