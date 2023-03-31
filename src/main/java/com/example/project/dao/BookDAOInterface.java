package com.example.project.dao;

import com.example.project.model.Book;
import com.example.project.model.User;

import java.util.List;
import java.util.Optional;

public interface BookDAOInterface {
    List<Book> index();
    Book show(int id);
    void save(Book book);
    void update(int id, Book updatedBook);
    void delete(int id);
    Optional<User> gerBookAuthor(int id);
    void assign(int id, User selectedUser);
}
