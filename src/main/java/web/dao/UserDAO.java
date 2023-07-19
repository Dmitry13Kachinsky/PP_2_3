package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> users();
    public void add(User user);
    void delete(int id);
    void edit(int id, User user);
    User show(int id);

}
