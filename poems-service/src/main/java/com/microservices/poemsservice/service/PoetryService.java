package com.microservices.poemsservice.service;

import com.microservices.poemsservice.model.Poetry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PoetryService{
    public List<Poetry> getAllPoetries();
    public Poetry savePoetry(Poetry poetry);
    public List<Poetry> findPoetryByTitle(String title);
    public List<Poetry> findPoetriesByAuthor(String title);
}
