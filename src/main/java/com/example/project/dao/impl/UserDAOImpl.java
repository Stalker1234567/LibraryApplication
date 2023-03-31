package com.example.project.dao.impl;

import com.example.project.dao.UserDAOInterface;
import com.example.project.model.Book;
import com.example.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAOImpl implements UserDAOInterface {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> index() {
        return jdbcTemplate.query("SELECT * FROM User", new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User show(int id) {
        return jdbcTemplate.query("SELECT * FROM User WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(User.class))
                .stream().findAny().orElse(null);
    }

    @Override
    public void save(User user) {
        jdbcTemplate.update("INSERT INTO User VALUES(1, ?, ?, ?)", user.getName(), user.getAge(),
                user.getEmail());
    }

    @Override
    public void update(int id, User updatedUser) {
        jdbcTemplate.update("UPDATE User SET name=?, age=?, email=? WHERE id=?", updatedUser.getName(),
                updatedUser.getAge(), updatedUser.getEmail(), id);
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM User WHERE id=?", id);
    }

    @Override
    public List<Book> getBooksByUserId(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE user_id = ?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class));
    }
}
