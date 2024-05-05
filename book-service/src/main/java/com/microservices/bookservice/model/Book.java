package com.microservices.bookservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Books")
public class Book {
    @Id
    private String id;
    private List<Docs> docs;
}

