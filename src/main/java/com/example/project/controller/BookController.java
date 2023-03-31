package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {
    @GetMapping()
    public String listBooks() {
        return "books";
    }

    @GetMapping("/new")
    public String createNewBook() {
        return "createBook";
    }
}
