package com.microservices.bookservice.model;

import lombok.Data;

import java.util.List;

@Data
public class Spec {
    private List<String> author_key;
}
