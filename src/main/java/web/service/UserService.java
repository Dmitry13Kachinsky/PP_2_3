package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void add(User user);
    void delete(int id);
    void edit(int id, User user);
    User getUserById(int id);
}
