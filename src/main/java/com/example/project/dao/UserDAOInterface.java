package com.example.project.dao;

import com.example.project.model.Book;
import com.example.project.model.User;

import java.util.List;

public interface UserDAOInterface {
    List<User> index();
    User show(int id);
    void save(User person);
    void update(int id, User updatedPerson);
    void delete(int id);
    List<Book> getBooksByUserId(int id);
}
