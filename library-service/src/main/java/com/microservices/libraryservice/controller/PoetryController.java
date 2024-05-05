package com.microservices.libraryservice.controller;

import com.microservices.libraryservice.model.Poetry;
import com.microservices.libraryservice.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PoetryController {
    private final LibraryService libraryService;

    @Autowired
    public PoetryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("poetry/{title}")
    public List<Poetry> getPoetryByTitle(@PathVariable String title){
        return libraryService.getPoetryByTitle(title);
    }

    @GetMapping("poetries/{author}")
    public List<Poetry> getPoetryByAuthor(@PathVariable String author){
        return libraryService.getPoetriesByAuthor(author);
    }
}
