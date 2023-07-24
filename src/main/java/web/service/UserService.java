package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> users();
    void add(User user);
    void delete(int id);
    void edit(int id, User user);
    User getUserBy(int id);
}
