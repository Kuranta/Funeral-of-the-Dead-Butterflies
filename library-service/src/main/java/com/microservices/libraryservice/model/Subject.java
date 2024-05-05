package com.microservices.libraryservice.model;

import lombok.Data;

import java.util.List;

@Data
public class Subject {
    private String name;
    private List<Works> works;
}
