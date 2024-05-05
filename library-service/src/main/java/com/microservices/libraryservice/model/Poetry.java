package com.microservices.libraryservice.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class Poetry {
    private String title;
    private String author;
    private String[] lines;
    private int linecount;
}
