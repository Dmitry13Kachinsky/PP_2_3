package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> users() {
        return jdbcTemplate.query("SELECT * FROM users", new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public void add(User user) {
        jdbcTemplate.update("INSERT INTO users(name, surname) VALUES (?, ?)", user.getName(), user.getSurname());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM users WHERE id=?", id);
    }

    @Override
    public void edit(int id, User updatedUser) {
        jdbcTemplate.update("UPDATE users SET name=?, surname=? WHERE id=?", updatedUser.getName(), updatedUser.getSurname(), id);
    }

    @Override
    public User show(int id) {
        return jdbcTemplate.query("SELECT * FROM users WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(User.class)).stream().findAny().orElse(null);
    }
}
