package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> users(int count);
    void add(User user);
    void delete(User user);
    void edit(User user);
    User show(int id);
}
