package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class UserController {
    @GetMapping()
    public String listUsers() {
        return "users";
    }

    @GetMapping("/new")
    public String createNewUser() {
        return "createUser";
    }


}
