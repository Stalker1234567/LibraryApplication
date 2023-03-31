package com.example.project.dao.impl;

import com.example.project.dao.BookDAOInterface;
import com.example.project.model.Book;
import com.example.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

public class BookDAOImpl implements BookDAOInterface {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }

    @Override
    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO Book VALUES(1, ?, ?, ?)", book.getTitle(), book.getYear(),
                book.getAuthor());
    }

    @Override
    public void update(int id, Book updatedBook) {
        jdbcTemplate.update("UPDATE Book SET name=?, age=?, email=? WHERE id=?", updatedBook.getTitle(),
                updatedBook.getYear(), updatedBook.getAuthor(), id);
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Book WHERE id=?", id);
    }

    @Override
    public Optional<User> gerBookAuthor(int id) {
        return jdbcTemplate.query("SELECT User.* FROM Book JOIN User ON Book.user_id = User.id" +
                "WHERE Book.id = ?", new Object[]{id},
                new BeanPropertyRowMapper<>(User.class))
                .stream().findAny();
    }

    @Override
    public void assign(int id, User selectedUser) {
        jdbcTemplate.update("UPDATE Book SET user_id=? WHERE id=?",
                selectedUser.getId(), id);
    }

}
