package com.microservices.libraryservice.model;

import lombok.Data;

import java.util.List;

@Data
public class Docs {
    private String[] author_name;
    private String title;
    private int number_of_pages_median;
    private int first_publish_year;
    private float ratings_average;
    private List<String> person;
}
