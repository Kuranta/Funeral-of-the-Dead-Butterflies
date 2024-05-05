package com.microservices.poemsservice.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.microservices.poemsservice.model.Poetry;
import com.microservices.poemsservice.service.PoetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v3")
public class PoetryController {
    private final PoetryService poetryService;

    @Autowired
    public PoetryController(PoetryService poetryService) {
        this.poetryService = poetryService;
    }

    @GetMapping("/getPoetry/{title}")
    public List<Poetry> getPoetryByTitle(@PathVariable String title){
        return poetryService.findPoetryByTitle(title);
    }

    @GetMapping("/getPoetries/{author}")
    public List<Poetry> getAuthorPoetries(@PathVariable String author){
        return poetryService.findPoetriesByAuthor(author);
    }





}
