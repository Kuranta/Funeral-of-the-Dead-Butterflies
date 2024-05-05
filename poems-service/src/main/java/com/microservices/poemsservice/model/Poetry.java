package com.microservices.poemsservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Poetry")
public class Poetry {
    private String title;
    private String author;
    private String[] lines;
    private int linecount;
}
