package com.microservices.libraryservice.model;

import lombok.Data;

import java.util.List;

@Data
public class Works {
    private String key;
    private String title;
    private List<Authors> authors;
}
